package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.foreman.entities.Order;
import ru.goryachev.foreman.service.BillPositionService;
import ru.goryachev.foreman.service.ConstructionService;
import ru.goryachev.foreman.service.OrderService;

@Controller
@RequestMapping("/construction")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ConstructionService constructionService;

    @Autowired
    public BillPositionService billPositionService;

    //CRUD for orders:
    //read: orders for employees, the first page:
    @GetMapping("/{name}/orders-editable")
    public String constructionOrdersEdit (@PathVariable("name") String name, Model model) {
        model.addAttribute("changeableList", orderService.getChangeablePresentable(constructionService.getByName(name).getId()));
        model.addAttribute("postedList", orderService.getPostedPresentable(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orders_edit";
    }

    //read: orders for employees, the second page:
    @GetMapping("/{name}/orders-acceptable")
    public String constructionOrdersAccept (@PathVariable("name") String name, Model model) {
        model.addAttribute("sentList", orderService.getSentPresentable(constructionService.getByName(name).getId()));
        model.addAttribute("billpositionList", billPositionService.getByConstruction(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orders_accept";
    }

    //read: orders for employees, the third page (archive):
    @GetMapping("/{name}/orders-final")
    public String constructionOrdersArchive (@PathVariable("name") String name, Model model) {
        model.addAttribute("executedList", orderService.getExecutedPresentable(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orders_finalchk";
    }

    //create order:
    @PostMapping("{name}/orders/add")
    public String addOrderBeta (@PathVariable("name") String name) {
        orderService.setParameters(constructionService.getByName(name).getId());
        Order order = new Order();
        orderService.save(order);
        return "redirect:/construction/{name}/orders-editable";
    }

    //delete order:
    @PostMapping("{name}/orders/{id}/del")
    public String delOrder (@PathVariable("name") String name, @PathVariable("id") int id) {
        orderService.delete(id);
        return "redirect:/construction/{name}/orders-editable";
    }


    //read: orders (for suppliers)
    @GetMapping("/supplier")
    public String supplierOrders (Model model) {
        model.addAttribute("postedAllList", orderService.getPostedAllPresentable());
        model.addAttribute("sentAllList", orderService.getSentAllPresentable());
        return "supplier_page";
    }

    @GetMapping("/archive")
    public String ordersArchive (Model model) {
        model.addAttribute("executedAllList", orderService.getExecutedAllPresentable());
        return "orders_archive";
    }


    /*
    @GetMapping("/order/{id}/edit")
    public String Order () {
        return "orders_edit";
    }


    @GetMapping("/order/{id}")
    public String Order () {
        return "orders_page";
    }*/

}
