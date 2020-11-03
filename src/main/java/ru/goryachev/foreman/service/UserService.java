package ru.goryachev.foreman.service;

import org.springframework.stereotype.Service;
import ru.goryachev.foreman.entities.User;
import java.util.List;

@Service
public class UserService implements Applicable {

    @Override
    public List<User> getAll() {
        return null;
    }

}
