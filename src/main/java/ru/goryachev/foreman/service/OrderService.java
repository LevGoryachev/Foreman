package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.OrdersDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Order;
import ru.goryachev.foreman.dto.OrderDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private int currentConstructionID;
    private int currentUserID;
    private LocalDateTime currentOrderTime;

    @Autowired
    private OrdersDAO ordersDAO;

    @Autowired
    private AppUserService appUsersService;

    @Autowired
    private ConstructionService constructionService;

    //for a while is used getAll(DAO) instead this
    public List<Order> getAll() {
        return ordersDAO.getAll();
    }

    public void create(Entity entity) {
        Order order = ((Order) entity);
        order.setConstructionId(currentConstructionID);
        order.setOrdertime(currentOrderTime);
        order.setPosted(false);
        order.setSent(false);
        order.setStatusExecuted(false);
        order.setAppUserId(currentUserID);
        ordersDAO.create(order);
    }

    //automatically set fields when saving an order (save(Entity entity))
    public void setParameters (int currentConstructionID) {
        this.currentConstructionID = currentConstructionID;
        this.currentOrderTime = LocalDateTime.now();
        this.currentUserID = appUsersService.getCurrentUser().getId(); // extract user from session
    }

    //to set order's STATUS 2
    public void updateSetPosted(int id) {
        Order order = this.getById(id);
        order.setPosted(true);
        ordersDAO.update(order);
    }

    //to set order's STATUS 3
    public void updateSetSent(int id) {
        Order order = this.getById(id);
        order.setSent(true);
        ordersDAO.update(order);
    }

    //to set order's STATUS 4
    public void updateSetExecuted(int id) {
        Order order = this.getById(id);
        order.setStatusExecuted(true);
        ordersDAO.update(order);
    }

    public void delete(int id) {
        //"IF statement" to avoid any changes with orders (and positions) that have STATUS 2 or 3 or 4
        if (!this.getById(id).isPosted() && !this.getById(id).isSent() && !this.getById(id).isStatusExecuted()) {
            ordersDAO.delete(id);
        }
    }

    public Order getById(int id) {
        return ordersDAO.getById(id);
    }

    public OrderDTO getDTOById(int id) {

        OrderDTO orderDTO = new OrderDTO();
        Order order = ordersDAO.getById(id);

        orderDTO.setId(order.getId());
        orderDTO.setOrderTime(order.getOrdertime());
        orderDTO.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
        orderDTO.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
        return orderDTO;
    }


    //get by construction ID for EMPLOYEE pages, orders with STATUS 1 (edit)
    public List<OrderDTO> getDTOChangeable(int currentConstructionID) {
        List<OrderDTO> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (currentConstructionID == order.getConstructionId() && !order.isPosted() && !order.isSent() && !order.isStatusExecuted()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setOrderTime(order.getOrdertime());
                orderDTO.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderDTO.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderDTO);

            }
        }
        return list;
    }

    //get by construction ID for EMPLOYEE pages, orders with STATUS 2 (posted to supply)
    public List<OrderDTO> getDTOPosted(int currentConstructionID) {
        List<OrderDTO> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (currentConstructionID == order.getConstructionId() && order.isPosted() && !order.isSent() && !order.isStatusExecuted()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setOrderTime(order.getOrdertime());
                orderDTO.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderDTO.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderDTO);
            }
        }
        return list;
    }

    //get by construction ID for EMPLOYEE pages, orders with STATUS 3 (when supplier sent the materials)
    public List<OrderDTO> getDTOSent(int currentConstructionID) {
        List<OrderDTO> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (currentConstructionID == order.getConstructionId() && order.isPosted() && order.isSent() && !order.isStatusExecuted()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setOrderTime(order.getOrdertime());
                orderDTO.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderDTO.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderDTO);
            }
        }
        return list;
    }

    //get by construction ID for EMPLOYEE pages, orders with STATUS 4 (when the employee received the materials on construction site)
    //method is not used in the current version
    public List<OrderDTO> getDTOExecuted(int currentConstructionID) {
        List<OrderDTO> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (currentConstructionID == order.getConstructionId() && order.isStatusExecuted()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setOrderTime(order.getOrdertime());
                orderDTO.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderDTO.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderDTO);
            }
        }
        return list;
    }


    //get all (all constructions) for SUPPLIER pages, orders with STATUS 2
    public List<OrderDTO> getDTOPostedAll() {
        List<OrderDTO> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (order.isPosted() && !order.isSent() && !order.isStatusExecuted()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setOrderTime(order.getOrdertime());
                orderDTO.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderDTO.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderDTO);
            }
        }
        return list;
    }

    //get all (all constructions) for SUPPLIER pages, orders with STATUS 3
    //method is not used in the current version
    public List<OrderDTO> getDTOSentAll() {
        List<OrderDTO> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (order.isPosted() && order.isSent() && !order.isStatusExecuted()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setOrderTime(order.getOrdertime());
                orderDTO.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderDTO.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderDTO);
            }
        }
        return list;
    }

    //get all (all constructions) for SUPPLIER pages, orders with STATUS 4 (archive of orders)
    public List<OrderDTO> getDTOExecutedAll() {
        List<OrderDTO> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (order.isStatusExecuted()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setOrderTime(order.getOrdertime());
                orderDTO.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderDTO.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderDTO);
            }
        }
        return list;
    }
}
