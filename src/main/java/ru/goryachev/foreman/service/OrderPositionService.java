package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.OrderPositionDAO;
import ru.goryachev.foreman.entities.Entity;
import ru.goryachev.foreman.entities.OrderPosition;
import java.util.List;

@Service
public class OrderPositionService implements Applicable {

    @Autowired
    public OrderPositionDAO orderPositionDAO;

    @Override
    public List<OrderPosition> getAll() {
        return orderPositionDAO.getAll();
    }

    @Override
    public void save(Entity entity) {

    }

    @Override
    public void update(Entity entity) {

    }

    @Override
    public void delete(int id) {

    }

}
