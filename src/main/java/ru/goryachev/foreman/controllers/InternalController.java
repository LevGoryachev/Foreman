package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.goryachev.foreman.service.ConstructionService;

@Controller
@RequestMapping("/construction")
public class InternalController {

    @Autowired
    public ConstructionService constructionService;

    @GetMapping("/{name}")
    public String showByid(@PathVariable("name") String name, Model model) {
    model.addAttribute("showConstruction", constructionService.getByName(name));
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
