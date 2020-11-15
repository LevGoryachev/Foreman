package ru.goryachev.foreman.service;

import ru.goryachev.foreman.entities.Entity;

import java.util.List;

public interface Applicable {

    List getAll();

    void save(Entity entity);

    void update (Entity entity);

    void delete (int id);
}
