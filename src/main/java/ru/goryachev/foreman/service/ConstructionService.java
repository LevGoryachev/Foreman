package ru.goryachev.foreman.service;

import org.springframework.stereotype.Service;
import ru.goryachev.foreman.entities.Construction;
import java.util.List;

@Service
public class ConstructionService implements Applicable {

    @Override
    public List<Construction> getAll() {
        return null;
    }

}
