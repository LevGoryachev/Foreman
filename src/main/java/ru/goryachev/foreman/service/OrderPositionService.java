package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.OrderPositionDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.OrderPosition;
import ru.goryachev.foreman.entities.OrderPositionPresentable;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderPositionService implements Applicable {

    @Autowired
    public OrderPositionDAO orderPositionDAO;

    @Autowired
    public OrderService orderService;

    @Autowired
    public ConstructionService constructionService;

    @Autowired
    public MaterialService materialService;


    @Override
    public List<OrderPosition> getAll() {
        return orderPositionDAO.getAll();
    }

    @Override
    public void create(Entity entity) {
        OrderPosition orderPosition = ((OrderPosition) entity);
        //"IF statement" to avoid any changes with orders (and positions) that have STATUS 2 or 3 or 4
        if (!orderService.getById(orderPosition.getOrderid()).isPosted() && !orderService.getById(orderPosition.getOrderid()).isSent() && !orderService.getById(orderPosition.getOrderid()).isStatusExecuted()) {
            orderPositionDAO.create(entity);
        }
    }

    @Override
    public void update(Entity entity) {
        OrderPosition orderPosition = ((OrderPosition) entity);
        //"IF statement" to avoid any changes with orders (and positions) that have STATUS 2 or 3 or 4
        if (!orderService.getById(orderPosition.getOrderid()).isPosted() && !orderService.getById(orderPosition.getOrderid()).isSent() && !orderService.getById(orderPosition.getOrderid()).isStatusExecuted()) {
         //body of method
        }

    }

    @Override
    public void delete(int id) {
    }

    //Overloaded. It's better to change delete (int id) delete(int...varargs) later
    public void delete(int construction_id, int material_id, int order_id) {
        //"IF statement" to avoid any changes with orders (and positions) that have STATUS 2 or 3 or 4
        if (!orderService.getById(order_id).isPosted() && !orderService.getById(order_id).isSent() && !orderService.getById(order_id).isStatusExecuted()) {
            orderPositionDAO.delete(construction_id, material_id, order_id);
        }
    }

    public List<OrderPositionPresentable> getByOrderIdPresentable(int orderId) {
        List<OrderPositionPresentable> list = new ArrayList<>();

        for (OrderPosition orderPosition: this.getAll()) {
            if (orderPosition.getOrderid() == orderId) {
                OrderPositionPresentable orderPositionPresentable = new OrderPositionPresentable();
                orderPositionPresentable.setConstructionId(orderPosition.getConstructionid());
                orderPositionPresentable.setMaterialId(orderPosition.getMaterialid());
                orderPositionPresentable.setOrderId(orderPosition.getOrderid());
                orderPositionPresentable.setConstructionName(constructionService.getById(orderPosition.getConstructionid()).getName());
                orderPositionPresentable.setMaterialName(materialService.getById(orderPosition.getMaterialid()).getName());
                orderPositionPresentable.setOrderqty(orderPosition.getOrderqty());
                list.add(orderPositionPresentable);
            }
        }
        return list;
    }
}
