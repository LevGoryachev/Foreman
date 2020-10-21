package ru.goryachev.foreman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/construction")
public class InternalController {

    @GetMapping("/main")
    public String constructionMainPage () {
        return "constructionpage";
    }

    @GetMapping("/materials")
    public String constructionMaterials () {
        return "billofmaterials";
    }

    @GetMapping("/orders")
    public String constructionOrders () {
        return "listoforders";
    }

}
