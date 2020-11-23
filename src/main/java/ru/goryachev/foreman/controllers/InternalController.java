package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.service.BillPositionService;
import ru.goryachev.foreman.service.ConstructionService;
import ru.goryachev.foreman.service.MaterialService;

@Controller
@RequestMapping("/construction")
public class InternalController {

    @Autowired
    public ConstructionService constructionService;

    @Autowired
    public BillPositionService billPositionService;

    @Autowired
    public MaterialService materialService;

    @GetMapping("/{name}")
    public String showByid(@PathVariable("name") String name, Model model) {
    model.addAttribute("showConstruction", constructionService.getByName(name));
        return "constructionpage";
    }

    //read: billposition (constructionMaterials)
    @GetMapping("/{name}/materials")
    public String constructionMaterials (@PathVariable("name") String name, Model model) {
        model.addAttribute("serviceList", billPositionService.getByConstruction(constructionService.getByName(name).getId()));
        return "billofmaterials";
    }

    //CRUD: billposition
    @GetMapping("/{name}/materials/editable")
    public String constructionMaterialsEditable (@PathVariable("name") String name, Model model) {
        model.addAttribute("serviceList", billPositionService.getByConstruction(constructionService.getByName(name).getId()));
        model.addAttribute("allMaterialsList", materialService.getAll());
        return "billofmaterialsedit";
    }

    //create: billposition
    @PostMapping("/{name}/materials/editable/add")
    public String addBillPosition (@PathVariable("name") String name, @ModelAttribute("billposition") BillPosition billPosition) {
        billPositionService.save(billPosition);
        return "redirect:/construction/{name}/materials/editable";
    }

    //delete: billposition
    @GetMapping ("/{name}/materials/editable/del/{materialId}")
    public String delBillPosition (@PathVariable("name") String name, @PathVariable("materialId") int materialId) {
        billPositionService.delete(constructionService.getByName(name).getId(), materialId);
        return "redirect:/construction/{name}/materials/editable";
    }



    @GetMapping("/orders")
    public String constructionOrders () {
        return "listoforders";
    }
}
