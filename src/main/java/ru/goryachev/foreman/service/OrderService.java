package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.OrdersDAO;
import ru.goryachev.foreman.entities.Order;
import java.util.List;

@Service
public class OrderService implements Applicable {

    @Autowired
    public OrdersDAO ordersDAO;

    @Override
    public List<Order> getAll() {
        return ordersDAO.getAll();
    }

}
