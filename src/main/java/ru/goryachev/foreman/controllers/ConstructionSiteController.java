package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.foreman.entities.BillPosition;
import ru.goryachev.foreman.entities.Order;
import ru.goryachev.foreman.entities.OrderPosition;
import ru.goryachev.foreman.service.*;

@Controller
@RequestMapping("/construction")
public class ConstructionSiteController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ConstructionService constructionService;

    @Autowired
    public MaterialService materialService;

    @Autowired
    public BillPositionService billPositionService;

    @Autowired
    public OrderPositionService orderPositionService;

    @GetMapping("/{name}")
    public String showByid(@PathVariable("name") String name, Model model) {
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "construction_page";
    }

    //CRUD: billposition
    //read: billposition (constructionMaterials)
    @GetMapping("/{name}/materials")
    public String constructionMaterials (@PathVariable("name") String name, Model model) {
        model.addAttribute("serviceList", billPositionService.getByConstruction(constructionService.getByName(name).getId()));
        return "bill_of_materials";
    }

    //mapping for admins and c-level
    @GetMapping("/{name}/materials-editable")
    public String constructionMaterialsEditable (@PathVariable("name") String name, Model model) {
        model.addAttribute("serviceList", billPositionService.getByConstruction(constructionService.getByName(name).getId()));
        model.addAttribute("allMaterialsList", materialService.getAll());
        return "bill_edit";
    }

    //create: billposition
    @PostMapping("/{name}/materials/editable/add")
    public String addBillPosition (@PathVariable("name") String name, @ModelAttribute("billposition") BillPosition billPosition) {
        billPositionService.save(billPosition);
        return "redirect:/construction/{name}/materials-editable";
    }

    //delete: billposition
    @PostMapping ("/{name}/materials/editable/del/{materialId}")
    public String delBillPosition (@PathVariable("name") String name, @PathVariable("materialId") int materialId) {
        billPositionService.delete(constructionService.getByName(name).getId(), materialId);
        return "redirect:/construction/{name}/materials-editable";
    }


    //CRUD for orders, orderpositions:
    //read: orders for employees, FIRST: ORDERS (editable)
    @GetMapping("/{name}/orders-editable")
    public String constructionOrdersEdit (@PathVariable("name") String name, Model model) {
        model.addAttribute("changeableList", orderService.getChangeablePresentable(constructionService.getByName(name).getId()));
        model.addAttribute("postedList", orderService.getPostedPresentable(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orders_editable";
    }

            //read: sub-page of FIRST (edit order positions):
            @GetMapping("/{name}/order/{orderId}/orderpositions-edit")
            public String orderPositionsEdit (@PathVariable("name") String name, @PathVariable("orderId") int orderId, Model model) {
                //left side
                model.addAttribute("orderpositionsList", orderPositionService.getByOrderIdPresentable(orderId));

                //getDeductionOfList: if current ORDER already contains these positions (materials) - they should NOT be available in the current ORDER
                model.addAttribute("billpositionList", billPositionService.getDeductionOfList(constructionService.getByName(name).getId(), orderId));

                model.addAttribute("orderAttributes", orderService.getByIdPresentable(orderId));
                model.addAttribute("showConstruction", constructionService.getByName(name));
                model.addAttribute("showOrderId", orderId);

                //right side
                model.addAttribute("postedList", orderService.getPostedPresentable(constructionService.getByName(name).getId()));
                return "orderpositions_edit";
            }

            //create: orderposition
            @PostMapping("/{name}/order/{orderId}/orderposition/add")
            public String addOrderPosition (@PathVariable("name") String name, @ModelAttribute("orderposition") OrderPosition orderPosition, @PathVariable("orderId") int orderId) {
                orderPositionService.save(orderPosition);
                return "redirect:/construction/{name}/order/{orderId}/orderpositions-edit";
            }

            //delete: orderposition
            @PostMapping ("/{name}/order/{orderId}/orderposition/del/{materialId}")
            public String delOrderPosition (@PathVariable("name") String name, @PathVariable("materialId") int materialId, @PathVariable("orderId") int orderId) {
                orderPositionService.delete(constructionService.getByName(name).getId(), materialId, orderId);
                return "redirect:/construction/{name}/order/{orderId}/orderpositions-edit";
            }


    //read: orders for employees, SECOND: ACCEPTANCE
    @GetMapping("/{name}/orders-acceptable")
    public String constructionOrdersAccept (@PathVariable("name") String name, Model model) {
        model.addAttribute("sentList", orderService.getSentPresentable(constructionService.getByName(name).getId()));
        model.addAttribute("billpositionList", billPositionService.getByConstruction(constructionService.getByName(name).getId()));
        model.addAttribute("showConstruction", constructionService.getByName(name));
        return "orders_acceptable";
    }

            //read: sub-page of SECOND (read and check order positions):
            @GetMapping("/{name}/order/{orderId}/orderpositions-check")
            public String orderPositionsCheck (@PathVariable("name") String name, @PathVariable("orderId") int orderId, Model model) {
                model.addAttribute("orderpositionsList", orderPositionService.getByOrderIdPresentable(orderId));
                model.addAttribute("orderAttributes", orderService.getByIdPresentable(orderId));
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
