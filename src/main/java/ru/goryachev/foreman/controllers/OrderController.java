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

    //CRUD for orders, orderpositions:
    //read: orders for employees, the first page:
    @GetMapping("/{name}/orders-editable")
    public String constructionOrdersEdit (@PathVariable("name") String name, Model model) {
        model.addAttribute("changeableList", orderService.getChangeablePresentable(constructionService.getByName(name).getId()));
        model.addAttribute("postedList", orderService.getPostedPresentable(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orders_editable";
    }

    //read: sub-page of first :
    @GetMapping("/{name}/orderpositions/edit")
    public String orderPositionsEdit (@PathVariable("name") String name, Model model) {
        //+ also model: add OrderPositions
        model.addAttribute("postedList", orderService.getPostedPresentable(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orderpositions_edit";
    }

    //read: orders for employees, the second page:
    @GetMapping("/{name}/orders-acceptable")
    public String constructionOrdersAccept (@PathVariable("name") String name, Model model) {
        model.addAttribute("sentList", orderService.getSentPresentable(constructionService.getByName(name).getId()));
        model.addAttribute("billpositionList", billPositionService.getByConstruction(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orders_acceptable";
    }

    //read: sub-page of second :
    @GetMapping("/{name}/orderpositions/check")
    public String orderPositionsCheck (@PathVariable("name") String name, Model model) {
        //+ alsomodel: add OrderPositions
        model.addAttribute("billpositionList", billPositionService.getByConstruction(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orderpositions_check";
    }

    //create order:
    @PostMapping("{name}/orders/add")
    public String addOrderBeta (@PathVariable("name") String name) {
        orderService.setParameters(constructionService.getByName(name).getId());
        Order order = new Order();
        orderService.save(order);
        return "redirect:/construction/{name}/orders-editable";
    }

    //update order (set status POSTED)
    @PostMapping("{name}/orders/{id}/posted")
    public String updOrderSetPosted (@PathVariable("name") String name, @PathVariable("id") int id) {
        orderService.updateSetPosted(id);
        return "redirect:/construction/{name}/orders-editable";
    }

    //update order (set status SENT)
    /* the method only in case a supplier works in certain construction site (updOrderSetSent() replaces in SupplyDepController)
    @PostMapping("{name}/orders/{id}/sent")
    public String updOrderSetSent (@PathVariable("name") String name, @PathVariable("id") int id) {
        orderService.updateSetSent(id);
        return "redirect:/construction/{name}/orders-editable";
    }
    */

    //update order (set status EXECUTED)
    @PostMapping("{name}/orders/{id}/executed")
    public String updOrderSetExecuted (@PathVariable("name") String name, @PathVariable("id") int id) {
        orderService.updateSetExecuted(id);
        return "redirect:/construction/{name}/orders-acceptable";
    }

    //delete order:
    @PostMapping("{name}/orders/{id}/del")
    public String delOrder (@PathVariable("name") String name, @PathVariable("id") int id) {
        orderService.delete(id);
        return "redirect:/construction/{name}/orders-editable";
    }
}
