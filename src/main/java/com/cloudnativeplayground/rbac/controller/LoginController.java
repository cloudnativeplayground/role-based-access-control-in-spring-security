package com.cloudnativeplayground.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Returns a login view (login.html in templates folder for Thymeleaf)
    }
}
