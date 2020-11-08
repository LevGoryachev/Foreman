package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.UsersDAO;
import ru.goryachev.foreman.entities.User;
import java.util.List;

@Service
public class UserService implements Applicable {

    @Autowired
    public UsersDAO usersDAO;

    @Override
    public List<User> getAll() {
        return usersDAO.getAll();
    }

}