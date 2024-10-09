package com.sboot.controller;

import com.sboot.bean.UserBean;
import com.sboot.dao.UserDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String getDataFromSignupForm(@ModelAttribute("user") @Valid UserBean user, BindingResult res, Model model) {
//        System.out.println("First Name: " + user.getFirstName());
//        System.out.println("Email: " + user.getEmail());
//        System.out.println("Password: " + user.getPassword());

        if (res.hasErrors()) {
            return "signup";
        } else {
            userDao.addUser(user);
            return "redirect:/list";
        }
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<UserBean> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") Integer userId) {
        userDao.softDeleteUser(userId);
        return "redirect:/list";
    }

    @GetMapping("/listdeleted")
    public String listDeletedUsers(Model model) {
        List<UserBean> users = userDao.getDeletedUsers();
        model.addAttribute("users", users);
        return "list_deleted";
    }

}
