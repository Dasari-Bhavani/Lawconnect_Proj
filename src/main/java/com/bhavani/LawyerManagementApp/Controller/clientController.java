package com.bhavani.LawyerManagementApp.Controller;

import com.bhavani.LawyerManagementApp.Model.Client;
import com.bhavani.LawyerManagementApp.Service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class clientController {

    private final ClientService clientService;

    public clientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/registerClient")
    public ModelAndView registerClient(ModelAndView modelAndView) {
        modelAndView.addObject("client", new Client());
        modelAndView.setViewName("registerClient");
        return modelAndView;
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public ModelAndView addClient(@ModelAttribute("client") Client client, ModelAndView modelAndView) {
        modelAndView.addObject("client", clientService.registerClient(client));
        modelAndView.setViewName("DisplayClientDetails");
        return modelAndView;
    }

    @RequestMapping("/clientLogin")
    public ModelAndView clientLogin(HttpServletRequest req, ModelAndView modelAndView) {
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        String pin = req.getParameter("pin");
        int status = clientService.verifyClient(pid, pin);

        if (status == 1) {
            modelAndView.addObject("pid", pid);
            modelAndView.setViewName("clientFeatures");

        } else {
            modelAndView.setViewName("errorLogin");
        }
        return modelAndView;
    }

    @RequestMapping("/getClientsList")
    public String getListOfClients(Model model) {
        model.addAttribute("list", clientService.getListOfClients());
        return "clientsDetails";
    }

    @RequestMapping(value = "/bookLawyer", method = RequestMethod.POST)
    public ModelAndView bookLawyer(HttpServletRequest req, ModelAndView modelAndView) {
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        Integer did = Integer.parseInt(req.getParameter("did"));

        clientService.selectLawyer(pid, did);
        modelAndView.setViewName("appointmentSuccessful");
        return modelAndView;
    }

    @RequestMapping("/clientId")
    public String bookAppointment(HttpServletRequest req, Model model) {
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        model.addAttribute("pid", pid);
        return "bookAppointment";
    }

    @RequestMapping("/viewClientProfile")
    public String viewClientProfileBYId(HttpServletRequest req, Model model) {
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        Client client = clientService.getClientObject(pid);
        model.addAttribute("client", client);
        return "clientDetailsById";
    }

    @RequestMapping(value = "/updateOrDelete", method = RequestMethod.POST)
    public String performUpdateOrDelete(HttpServletRequest req, Model model) {
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        String action = req.getParameter("action");
        if (action.equals("update")) {
            Client client = clientService.getClientObject(pid);
            model.addAttribute("client", client);
            return "updateclientDetails";
        } else {
            clientService.deleteClientProfile(pid);
            return "cliDelSuccess";
        }
    }

    @RequestMapping(value = "/updateClient", method = RequestMethod.POST)
    public String updateClient(HttpServletRequest req, @ModelAttribute("client") Client client, Model model) {
        int pid = Integer.parseInt(req.getParameter("pid"));
        client.setPid(pid);
        model.addAttribute("client", clientService.updateClientProfile(client));
        return "clientDetailsById";
    }

}
