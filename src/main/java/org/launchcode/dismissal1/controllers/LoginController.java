
package org.launchcode.dismissal1.controllers;

import org.launchcode.dismissal1.models.User;
import org.launchcode.dismissal1.models.data.ChangetransportationDao;
import org.launchcode.dismissal1.models.data.EarlyDao;
import org.launchcode.dismissal1.models.data.StudentDao;
import org.launchcode.dismissal1.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller //MVC annotation to indicate this class is a controller.
@RequestMapping("home")  //maps HTTP requests to handler methods of MVC
public class LoginController {

    //Autowired-Springboot creates everything needed from DAO's to run controller
    @Autowired
    UserDao userDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    EarlyDao earlyDao;

    @Autowired
    ChangetransportationDao changetransportationDao;


    @RequestMapping(value="home")
    public String log(Model model) {
        return "home/home";
    }
    // Login Form Display
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "The Dismissal App");
        model.addAttribute(new User());
        return "home/login";
    }

    @RequestMapping(value ="login", method= RequestMethod.POST)
    public String login(Model model, @ModelAttribute User user, String verify_password){
        if (user.getPassword().equals(verify_password)){
            return "home/log";
        }
        model.addAttribute("error_message", "I'm sorry, but password doesn't match verify password. Please try again.");
        return "home/login";
    }


    //New Account form
    @RequestMapping(value = "newaccount", method = RequestMethod.GET)
    public String account(Model model) {
        model.addAttribute("title", "The Dismissal App");
        model.addAttribute(new User());
        return "home/newaccount";
    }

    //New Account process form
    @RequestMapping(value = "newaccount", method = RequestMethod.POST)
    public String accountProcess(@ModelAttribute @Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "New Account Sign-up");
            return "redirect:newaccount";
        }
        userDao.save(user);
        return "home/log";

    }
}




