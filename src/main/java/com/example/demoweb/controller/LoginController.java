package com.example.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(Model model) {

        model.addAttribute("saludo", "Hola mundo!");
        return "login";
    }

}
