package com.bhavani.LawyerManagementApp.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @RequestMapping("/adminLogin")
    public ModelAndView adminLogin(HttpServletRequest req, ModelAndView modelAndView) {
        String uname = req.getParameter("username");
        String password = req.getParameter("password");

        if (uname.equals(password) && uname.equals("admin")) {
            modelAndView.setViewName("adminFeatures");
        } else {
            modelAndView.setViewName("errorAdminLogin");
        }
        return modelAndView;
    }

}
