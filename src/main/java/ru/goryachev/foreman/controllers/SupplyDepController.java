package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.foreman.service.OrderPositionService;
import ru.goryachev.foreman.service.OrderService;

@Controller
@RequestMapping("/")
public class SupplyDepController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderPositionService orderPositionService;

    //read: orders with status POSTED (for suppliers)
    @GetMapping("/supplier")
    public String supplierOrders (Model model) {
        model.addAttribute("postedAllList", orderService.getDTOPostedAll());
        return "supplier_page";
    }

    //read: orderpositions in order with status POSTED (for suppliers) and reload the page
    @GetMapping("/supplier/{orderId}/orderpositions")
    public String supplierOrderPositions (@PathVariable("orderId") int orderId, Model model) {
        model.addAttribute("postedAllList", orderService.getDTOPostedAll());
        model.addAttribute("orderpositionsList", orderPositionService.getDTOByOrderId(orderId));
        model.addAttribute("orderAttributes", orderService.getDTOById(orderId));
        return "supplier_page";
    }

    //read: orders in status EXECUTED (for suppliers)
    @GetMapping("/archive")
    public String ordersArchive (Model model) {
        model.addAttribute("executedAllList", orderService.getDTOExecutedAll());
        return "orders_archive";
    }

    @GetMapping("/archive/{orderId}/orderpositions")
    public String ordersArchiveOrderPositions (@PathVariable("orderId") int orderId, Model model) {
        model.addAttribute("executedAllList", orderService.getDTOExecutedAll());
        model.addAttribute("orderpositionsList", orderPositionService.getDTOByOrderId(orderId));
        model.addAttribute("orderAttributes", orderService.getDTOById(orderId));
        return "orders_archive";
    }


    //update: orders button "Send"(for suppliers)
    @PostMapping("/orders/{id}/sent")
    public String updOrderSetSent (@PathVariable("id") int id) {
        orderService.updateSetSent(id);
        return "redirect:/supplier";
    }
}
