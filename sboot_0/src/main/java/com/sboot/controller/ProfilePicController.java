package com.sboot.controller;

import com.sboot.bean.UserBean;
import com.sboot.dao.UserDao;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class ProfilePicController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        UserBean loggedInUser = userDao.validateUser(email, password);
        if(loggedInUser != null) {
            session.setAttribute("user", loggedInUser);
            return "redirect:/user/profile";
        }
        model.addAttribute("error", "Invalid email or password!");
        return "login";
    }

    @GetMapping("/profile")
    public String viewProfile(HttpSession session, Model model) {
        UserBean user = (UserBean) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/login";
        }
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/uploadProfilePic")
    public String uploadProfilePic(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        UserBean user = (UserBean) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/login";
        }

        String uploadDir = "C:/Users/Shrey Kadia/Documents/Work/Shrey@Royal/Spring/24_Club__Spring/sboot_0/src/main/webapp/uploads/" + user.getEmail();
        File uploadDirectory = new File(uploadDir);
        if(!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }

        String fileName = file.getOriginalFilename();
        File destinationFile = new File(uploadDir + "/" + fileName);
        file.transferTo(destinationFile);

        userDao.updateProfilePicture(user.getUserId(), fileName);
        user.setProfilePic(fileName);

        return "redirect:/user/profile";
    }

    @PostMapping("/deleteProfilePic")
    public String deleteProfilePic(HttpSession session) {
        UserBean user = (UserBean) session.getAttribute("user");
        if(user == null) {
            return "redirect:/user/login";
        }

        userDao.updateProfilePicture(user.getUserId(), null);
        user.setProfilePic(null);

        return "redirect:/user/profile";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }

}
