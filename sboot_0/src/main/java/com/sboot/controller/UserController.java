package com.sboot.controller;

import com.sboot.bean.UserBean;
import com.sboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new UserBean()); // blank
        System.out.println("Signup");
        return "signup";
    }

    @PostMapping("/save")
    public String getDataFromSignupForm(@ModelAttribute("user") UserBean user, BindingResult res, Model model) {
        System.out.println(res.hasErrors());
        model.addAttribute("user", user);

        if (res.hasErrors()) {
            return "signup";
        } else {
            userDao.addUser(user);
            System.out.println(user.getFirstName());
            System.out.println(user.getEmail());
            return "home";
        }

    }

}
