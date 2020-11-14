package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.goryachev.foreman.entities.Construction;
import ru.goryachev.foreman.service.ConstructionService;
import ru.goryachev.foreman.service.MaterialService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    public ConstructionService constructionService;

    @Autowired
    public MaterialService materialService;

    @GetMapping("/login")
    public String loginForm () {
        return "loginpage";
    }

    @GetMapping ("/registration")
    public String regForm () {
        return "registrationpage";
    }

    @GetMapping ("/constructions")
    public String constructions (Model model) {
        model.addAttribute("constructionsList", constructionService.getAll());

        //Check List<>
        List <Construction> co = constructionService.getAll();
        System.out.println("Controller check: ready");
        for(Construction stroyka : co) {
            System.out.println("Controller check: " + stroyka);
        }
        if (co.isEmpty()){
            System.out.println("Controller check: LIST IS EMPTY");
        }

        return "listofconstructions";
    }


    @GetMapping ("/materials")
    public String materialsGeneral (Model model) {
        model.addAttribute("materialList", materialService.getAll());

        return "materialsgeneral";
    }

}
