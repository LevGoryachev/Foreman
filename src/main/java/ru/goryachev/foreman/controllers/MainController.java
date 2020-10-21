package ru.goryachev.foreman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/login")
    public String loginForm () {
        return "loginpage";
    }

    @GetMapping ("/registration")
    public String regForm () {
        return "registrationpage";
    }

    @GetMapping ("/constructions")
    public String constructions () {
        return "listofconstructions";
    }
}
