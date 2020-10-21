package ru.goryachev.foreman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/construction")
public class OrderController {

    @GetMapping("/order")
    public String Order () {
        return "order";
    }

}
