package com.example.login_register.controller;

import com.example.login_register.entity.User;
import com.example.login_register.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loginPage() {
        return "Login&Register";
    }

    @PostMapping("login")
    public String login(User user, HttpSession session, Model model) {
        String form_password = user.getPassword();
        if (userService.userNameIsExist(user.getUsername()) != null) {
            String password = userService.findUserPasswordByUserName(user.getUsername());
            if (password.equals(form_password)) {
                return "redirect:/index.html";
            }
        } else {
            model.addAttribute("msg", "账号或者密码有误");
            return "Login&Register";
        }
        return "Login&Register";
    }

    @PostMapping(value = "register")
    public String addUser(User user) {
        System.out.println(user.getUsername() + user.getPassword());
        userService.addUser(user.getUsername(), user.getPassword());
        return "redirect:/index.html";
    }

    @GetMapping("index.html")
    public String successPage(User user,HttpSession session, Model model) {
        return "index";
    }

//    @PostMapping("/table")
//    public String getAll(Model model) {
//        List<User> users = userService.getAll();
//        model.addAttribute("users", users);
//        System.out.println(users);
//        return "index";
//    }

}
