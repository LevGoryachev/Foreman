package ru.goryachev.foreman.service;

import org.springframework.stereotype.Service;
import ru.goryachev.foreman.entities.Order;
import java.util.List;

@Service
public class OrderService implements Applicable {

    @Override
    public List<Order> getAll() {
        return null;
    }

}
