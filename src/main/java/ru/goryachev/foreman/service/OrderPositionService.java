package ru.goryachev.foreman.service;

import org.springframework.stereotype.Service;
import ru.goryachev.foreman.entities.OrderPosition;
import java.util.List;

@Service
public class OrderPositionService implements Applicable {

    @Override
    public List<OrderPosition> getAll() {
        return null;
    }

}
