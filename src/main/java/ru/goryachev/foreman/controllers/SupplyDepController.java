package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.foreman.service.BillPositionService;
import ru.goryachev.foreman.service.ConstructionService;
import ru.goryachev.foreman.service.MaterialService;
import ru.goryachev.foreman.service.OrderService;

@Controller
@RequestMapping("/")
public class SupplyDepController {

    @Autowired
    public ConstructionService constructionService;

    @Autowired
    public BillPositionService billPositionService;

    @Autowired
    public MaterialService materialService;

    @Autowired
    public OrderService orderService;



    //read: orders (for suppliers)
    @GetMapping("/supplier")
    public String supplierOrders (Model model) {
        model.addAttribute("postedAllList", orderService.getPostedAllPresentable());
        return "supplier_page";
    }

    @GetMapping("/archive")
    public String ordersArchive (Model model) {
        model.addAttribute("executedAllList", orderService.getExecutedAllPresentable());
        return "orders_archive";
    }

    @PostMapping("/orders/{id}/sent")
    public String updOrderSetSent (@PathVariable("id") int id) {
        orderService.updateSetSent(id);
        return "redirect:/supplier";
    }
}
