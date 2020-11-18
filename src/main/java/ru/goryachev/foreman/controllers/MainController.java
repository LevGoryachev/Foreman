package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.*;
import ru.goryachev.foreman.entities.Construction;
import ru.goryachev.foreman.entities.Material;
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

    //read: constructions
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

    //create: constructions
    @PostMapping("/constructions/add")
    public String addConstructions (@ModelAttribute("construction") Construction construction) {
        constructionService.save(construction);
        return "redirect:/constructions";
    }

    //update: constructions
    @GetMapping ("/constructions/edit/{id}")
    public String editPageConstruction (@PathVariable("id") int id, Model model) {
        model.addAttribute("constructionEdit", constructionService.getById(id));
        return "editconstruction";
    }
    @PostMapping ("/constructions/upd")
    public String updateConstruction (@ModelAttribute ("construction") Construction construction) {
        constructionService.update(construction);
        return "redirect:/constructions";
    }

    //delete: constructions
    @GetMapping ("/constructions/del/{id}")
    public String delConstruction (@PathVariable("id") int id) {
        constructionService.delete(id);
        return "redirect:/constructions";
    }


    //read: materials
    @GetMapping ("/materials")
    public String materialsGeneral (Model model) {
        model.addAttribute("materialList", materialService.getAll());
        return "materialsgeneral";
    }

    //create: materials
    @PostMapping("/materials/add")
    public String addGeneralMaterial (@ModelAttribute("material") Material material) {
        materialService.save(material);
    return "redirect:/materials";
    }

    //update: materials
    @GetMapping ("/materials/edit/{id}")
    public String editPageGeneralMaterial (@PathVariable("id") int id, Model model) {
        model.addAttribute("materialEdit", materialService.getById(id));
        return "editmaterial";
    }
    @PostMapping ("/materials/upd")
    public String updateGeneralMaterial (@ModelAttribute ("material") Material material) {
        materialService.update(material);
        return "redirect:/materials";
    }

    //delete: materials
    @GetMapping ("/materials/del/{id}")
    public String delGeneralMaterial (@PathVariable("id") int id) {
        materialService.delete(id);

        return "redirect:/materials";
    }

}
