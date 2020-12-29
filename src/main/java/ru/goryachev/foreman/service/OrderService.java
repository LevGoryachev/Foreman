package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.OrdersDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Order;
import ru.goryachev.foreman.entities.OrderPresentable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements Applicable {

    private int currentConstructionID;
    private int currentUserID;
    private LocalDateTime currentOrderTime;

    @Autowired
    public OrdersDAO ordersDAO;

    @Autowired
    public AppUserService appUsersService;

    @Autowired
    public ConstructionService constructionService;

    @Override
    public List<Order> getAll() {
        return ordersDAO.getAll();
    }

    @Override
    public void save(Entity entity) {
        Order order = ((Order) entity);
        order.setConstructionId(currentConstructionID);
        order.setOrdertime(currentOrderTime);
        order.setPosted(false);
        order.setSent(false);
        order.setStatusExecuted(false);
        order.setAppUserId(currentUserID);
        ordersDAO.save(order);
    }

    //automatically set fields when saving an order (save(Entity entity))
    public void setParameters (int currentConstructionID) {
        this.currentConstructionID = currentConstructionID;
        this.currentOrderTime = LocalDateTime.now();
        this.currentUserID = 5; //temporary for debug
        //this.currentUserID = appUsersService.getCurrentUser().getId(); // extrsct user from session
    }

    @Override
    public void update(Entity entity) {
        ordersDAO.update(entity);
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

    @Override
    public void delete(int id) {
        //"IF statement" to avoid any changes with orders (and positions) that have STATUS 2 or 3 or 4
        if (!this.getById(id).isPosted() && !this.getById(id).isSent() && !this.getById(id).isStatusExecuted()) {
            ordersDAO.delete(id);
        }
    }

    public Order getById(int id) {
        return ordersDAO.getById(id);
    }

    public OrderPresentable getByIdPresentable(int id) {

        OrderPresentable orderPresentable = new OrderPresentable();
        Order order = ordersDAO.getById(id);

        orderPresentable.setId(order.getId());
        orderPresentable.setOrderTime(order.getOrdertime());
        orderPresentable.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
        orderPresentable.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
        return orderPresentable;
    }


    //get by construction ID for EMPLOYEE pages, orders with STATUS 1 (edit)
    public List<OrderPresentable> getChangeablePresentable(int currentConstructionID) {
        List<OrderPresentable> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (currentConstructionID == order.getConstructionId() && !order.isPosted() && !order.isSent() && !order.isStatusExecuted()) {
                OrderPresentable orderPresentable = new OrderPresentable();
                orderPresentable.setId(order.getId());
                orderPresentable.setOrderTime(order.getOrdertime());
                orderPresentable.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderPresentable.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderPresentable);

            }
        }
        return list;
    }

    //get by construction ID for EMPLOYEE pages, orders with STATUS 2 (posted to supply)
    public List<OrderPresentable> getPostedPresentable(int currentConstructionID) {
        List<OrderPresentable> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (currentConstructionID == order.getConstructionId() && order.isPosted() && !order.isSent() && !order.isStatusExecuted()) {
                OrderPresentable orderPresentable = new OrderPresentable();
                orderPresentable.setId(order.getId());
                orderPresentable.setOrderTime(order.getOrdertime());
                orderPresentable.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderPresentable.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderPresentable);
            }
        }
        return list;
    }

    //get by construction ID for EMPLOYEE pages, orders with STATUS 3 (when supplier sent the materials)
    public List<OrderPresentable> getSentPresentable(int currentConstructionID) {
        List<OrderPresentable> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (currentConstructionID == order.getConstructionId() && order.isPosted() && order.isSent() && !order.isStatusExecuted()) {
                OrderPresentable orderPresentable = new OrderPresentable();
                orderPresentable.setId(order.getId());
                orderPresentable.setOrderTime(order.getOrdertime());
                orderPresentable.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderPresentable.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderPresentable);
            }
        }
        return list;
    }

    //get by construction ID for EMPLOYEE pages, orders with STATUS 4 (when the employee received the materials on construction site)
    //method is not used in the current version
    public List<OrderPresentable> getExecutedPresentable(int currentConstructionID) {
        List<OrderPresentable> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (currentConstructionID == order.getConstructionId() && order.isStatusExecuted()) {
                OrderPresentable orderPresentable = new OrderPresentable();
                orderPresentable.setId(order.getId());
                orderPresentable.setOrderTime(order.getOrdertime());
                orderPresentable.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderPresentable.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderPresentable);
            }
        }
        return list;
    }


    //get all (all constructions) for SUPPLIER pages, orders with STATUS 2
    public List<OrderPresentable> getPostedAllPresentable() {
        List<OrderPresentable> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (order.isPosted() && !order.isSent() && !order.isStatusExecuted()) {
                OrderPresentable orderPresentable = new OrderPresentable();
                orderPresentable.setId(order.getId());
                orderPresentable.setOrderTime(order.getOrdertime());
                orderPresentable.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderPresentable.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderPresentable);
            }
        }
        return list;
    }

    //get all (all constructions) for SUPPLIER pages, orders with STATUS 3
    //method is not used in the current version
    public List<OrderPresentable> getSentAllPresentable() {
        List<OrderPresentable> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (order.isPosted() && order.isSent() && !order.isStatusExecuted()) {
                OrderPresentable orderPresentable = new OrderPresentable();
                orderPresentable.setId(order.getId());
                orderPresentable.setOrderTime(order.getOrdertime());
                orderPresentable.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderPresentable.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderPresentable);
            }
        }
        return list;
    }

    //get all (all constructions) for SUPPLIER pages, orders with STATUS 4 (archive of orders)
    public List<OrderPresentable> getExecutedAllPresentable() {
        List<OrderPresentable> list = new ArrayList<>();

        for (Order order: ordersDAO.getAll()) {
            if (order.isStatusExecuted()) {
                OrderPresentable orderPresentable = new OrderPresentable();
                orderPresentable.setId(order.getId());
                orderPresentable.setOrderTime(order.getOrdertime());
                orderPresentable.setConstructionName(constructionService.getById(order.getConstructionId()).getName());
                orderPresentable.setAppUserLastName(appUsersService.getById(order.getAppUserId()).getLastName());
                list.add(orderPresentable);
            }
        }
        return list;
    }
}
