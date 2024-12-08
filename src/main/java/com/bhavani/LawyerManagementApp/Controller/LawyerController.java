package com.bhavani.LawyerManagementApp.Controller;

//import com.bhavani.LawyerManagementApp.Model.Lawyer;
//import com.bhavani.LawyerManagementApp.Service.LawyerService;
import com.bhavani.LawyerManagementApp.Model.Lawyer;
import com.bhavani.LawyerManagementApp.Service.LawyerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LawyerController {

    private final LawyerService lawyerService;

    public LawyerController(LawyerService lawyerService) {
        this.lawyerService = lawyerService;
    }

    @RequestMapping("/registerLawyer")
    public String registerLawyer(Model model) {
        model.addAttribute("lawyer", new Lawyer());
        return "registerLawyer";
    }

    @RequestMapping(value = "/addLawyer", method = RequestMethod.POST)
    public String addLawyer(@ModelAttribute("lawyer") Lawyer lawyer, Model model) {
        model.addAttribute("lawyer", lawyerService.registerLawyer(lawyer));
        return "DisplayLawyerDetails";
    }

    @RequestMapping("/lawyerLogin")
    public ModelAndView LawyerLogin(HttpServletRequest req, ModelAndView modelAndView) {
        Integer did = Integer.parseInt(req.getParameter("did"));
        String pin = req.getParameter("pin");

        int status = lawyerService.verifyLawyer(did, pin);
        if (status == 1) {
            modelAndView.addObject("did", did);
            modelAndView.setViewName("LawyerFeatures");

        } else {
            modelAndView.setViewName("errorLawyerLogin");
        }
        return modelAndView;
    }

    @RequestMapping("/bookAppointment")
    public String getLawyersListBySpecialization(HttpServletRequest req, Model model) {
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        String specialization = req.getParameter("specialization");
        model.addAttribute("pid", pid);
        model.addAttribute("list", lawyerService.getLawyersBySpecialization(specialization));
        return "LawyersListBySpecialization";
    }

    @RequestMapping("/getLawyersList")
    public String getListOfLawyers(Model model) {
        model.addAttribute("list", lawyerService.getListOfLawyers());
        return "LawyersDetails";
    }

    @RequestMapping("/clientAppointments")
    public String getListOfClientAppointments(HttpServletRequest req, Model model) {
        int did = Integer.parseInt(req.getParameter("did"));
        model.addAttribute("list", lawyerService.getClientsAppointmentsList(did));
        return "cliAppointmentDetails";
    }

}
