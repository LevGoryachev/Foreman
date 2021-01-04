package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.foreman.entities.Construction;
import ru.goryachev.foreman.entities.Material;
import ru.goryachev.foreman.service.ConstructionService;
import ru.goryachev.foreman.service.MaterialService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    public ConstructionService constructionService;

    @Autowired
    public MaterialService materialService;

    //CRUD: constructions
    //read: constructions
    @GetMapping ("/constructions")
    public String constructions (Model model) {
        model.addAttribute("constructionsList", constructionService.getAll());
        return "constructions_all";
    }

    //mapping for admins and c-level
    @GetMapping ("/constructions-editable")
    public String constructionsEditable (Model model) {
        model.addAttribute("constructionsList", constructionService.getAll());
        return "constructions_edit";
    }

    //create: constructions
    @PostMapping("/constructions/add")
    public String addConstructions (@ModelAttribute("construction") Construction construction) {
        constructionService.create(construction);
        return "redirect:/constructions-editable";
    }

    //update: constructions
    @GetMapping ("/constructions/edit/{id}")
    public String editPageConstruction (@PathVariable("id") int id, Model model) {
        model.addAttribute("constructionEdit", constructionService.getById(id));
        return "construction_edit";
    }
    @PostMapping ("/constructions/upd")
    public String updateConstruction (@ModelAttribute ("construction") Construction construction) {
        constructionService.update(construction);
        return "redirect:/constructions-editable";
    }

    //delete: constructions
    @PostMapping ("/constructions/del/{id}")
    public String delConstruction (@PathVariable("id") int id) {
        constructionService.delete(id);
        return "redirect:/constructions-editable";
    }


    //CRUD: materials
    //read: materials
    @GetMapping ("/materials")
    public String materialsGeneral (Model model) {
        model.addAttribute("materialList", materialService.getAll());
        return "materials_all";
    }

    //mapping for admins and c-level
    @GetMapping ("/materials-editable")
    public String materialsGeneralEditable (Model model) {
        model.addAttribute("materialList", materialService.getAll());
        return "materials_edit";
    }

    //create: materials
    @PostMapping("/materials/add")
    public String addGeneralMaterial (@ModelAttribute("material") Material material) {
        materialService.create(material);
    return "redirect:/materials-editable";
    }

    //update: materials
    @GetMapping ("/materials/edit/{id}")
    public String editPageGeneralMaterial (@PathVariable("id") int id, Model model) {
        model.addAttribute("materialEdit", materialService.getById(id));
        return "material_edit";
    }
    @PostMapping ("/materials/upd")
    public String updateGeneralMaterial (@ModelAttribute ("material") Material material) {
        materialService.update(material);
        return "redirect:/materials-editable";
    }

    //delete: materials
    @PostMapping ("/materials/del/{id}")
    public String delGeneralMaterial (@PathVariable("id") int id) {
        materialService.delete(id);
        return "redirect:/materials-editable";
    }


    //Guide
    //read: guide
    @GetMapping ("/guide")
    public String guide (Model model) {
        model.addAttribute("constructionsList", constructionService.getAll());
        return "guide";
    }
}
