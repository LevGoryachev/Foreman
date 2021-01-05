package ru.goryachev.foreman.dao;

import ru.goryachev.foreman.entities.Entity;

import java.util.List;

public interface DataAccessible {

    List getAll();

    void create(Entity entity);

    void update (Entity entity);

    void delete (int id);

    Entity getById(int id);
}
