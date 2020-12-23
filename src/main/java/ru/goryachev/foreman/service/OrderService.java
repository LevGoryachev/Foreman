package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.OrdersDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.Order;

import java.time.LocalDateTime;
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

    public void setParameters (int currentConstructionID) {
        this.currentConstructionID = currentConstructionID;
        this.currentOrderTime = LocalDateTime.now();
        this.currentUserID = appUsersService.getCurrentUser().getId(); // extrsct user from session
    }

    @Override
    public void update(Entity entity) {
        ordersDAO.update(entity);
    }

    @Override
    public void delete(int id) {
        ordersDAO.delete(id);
    }

    public List<Order> getChangeable(int constructionId) {
        return ordersDAO.getChangeable(constructionId);
    }

    public List<Order> getPosted(int constructionId) {
        return ordersDAO.getPosted(constructionId);
    }

    public List<Order> getSent(int constructionId) {
        return ordersDAO.getSent(constructionId);
    }

    public List<Order> getExecuted(int constructionId) {
        return ordersDAO.getExecuted(constructionId);
    }

    public List<Order> getPostedAll() {
        return ordersDAO.getPostedAll();
    }

    public List<Order> getSentAll() {
        return ordersDAO.getSentAll();
    }

    public List<Order> getExecutedAll() {
        return ordersDAO.getExecutedAll();
    }

}
