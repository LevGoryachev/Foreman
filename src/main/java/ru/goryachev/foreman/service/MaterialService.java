package ru.goryachev.foreman.service;

import org.springframework.stereotype.Service;
import ru.goryachev.foreman.entities.Material;
import java.util.List;

@Service
public class MaterialService implements Applicable {

    @Override
    public List<Material> getAll() {
        return null;
    }

}
