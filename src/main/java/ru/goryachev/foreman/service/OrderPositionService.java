package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.OrderPositionDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.OrderPosition;
import ru.goryachev.foreman.dto.OrderPositionDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderPositionService {

    @Autowired
    private OrderPositionDAO orderPositionDAO;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ConstructionService constructionService;

    @Autowired
    private MaterialService materialService;

    public List<OrderPosition> getAll() {
        return orderPositionDAO.getAll();
    }

    public void create(Entity entity) {
        OrderPosition orderPosition = ((OrderPosition) entity);
        //"IF statement" to avoid any changes with orders (and positions) that have STATUS 2 or 3 or 4
        if (!orderService.getById(orderPosition.getOrderid()).isPosted() && !orderService.getById(orderPosition.getOrderid()).isSent() && !orderService.getById(orderPosition.getOrderid()).isStatusExecuted()) {
            orderPositionDAO.create(entity);
        }
    }

    public void update(Entity entity) {
        OrderPosition orderPosition = ((OrderPosition) entity);
        //"IF statement" to avoid any changes with orders (and positions) that have STATUS 2 or 3 or 4
        if (!orderService.getById(orderPosition.getOrderid()).isPosted() && !orderService.getById(orderPosition.getOrderid()).isSent() && !orderService.getById(orderPosition.getOrderid()).isStatusExecuted()) {
         //body of method
        }

    }

    public void delete(int construction_id, int material_id, int order_id) {
        //"IF statement" to avoid any changes with orders (and positions) that have STATUS 2 or 3 or 4
        if (!orderService.getById(order_id).isPosted() && !orderService.getById(order_id).isSent() && !orderService.getById(order_id).isStatusExecuted()) {
            orderPositionDAO.delete(construction_id, material_id, order_id);
        }
    }

    public List<OrderPositionDTO> getDTOByOrderId(int orderId) {
        List<OrderPositionDTO> list = new ArrayList<>();

        for (OrderPosition orderPosition: this.getAll()) {
            if (orderPosition.getOrderid() == orderId) {
                OrderPositionDTO orderPositionDTO = new OrderPositionDTO();
                orderPositionDTO.setConstructionId(orderPosition.getConstructionid());
                orderPositionDTO.setMaterialId(orderPosition.getMaterialid());
                orderPositionDTO.setOrderId(orderPosition.getOrderid());
                orderPositionDTO.setConstructionName(constructionService.getById(orderPosition.getConstructionid()).getName());
                orderPositionDTO.setMaterialName(materialService.getById(orderPosition.getMaterialid()).getName());
                orderPositionDTO.setOrderqty(orderPosition.getOrderqty());
                list.add(orderPositionDTO);
            }
        }
        return list;
    }
}
