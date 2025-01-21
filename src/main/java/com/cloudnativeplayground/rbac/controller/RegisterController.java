package com.cloudnativeplayground.rbac.controller;

import com.cloudnativeplayground.rbac.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserDto()); // Create a UserDto for registration
        return "register"; // Returns a register view (register.html in templates folder)
    }

    @PostMapping("/register")
    public String register(UserDto userDto) {
        // Add logic to save the user to the database
        return "redirect:/login"; // Redirect to login page after registration
    }
}
