package ru.goryachev.foreman.service;

import org.springframework.stereotype.Service;
import ru.goryachev.foreman.entities.BillPosition;
import java.util.List;

@Service
public class BillPositionService implements Applicable {

    @Override
    public List<BillPosition> getAll() {
        return null;
    }

}
