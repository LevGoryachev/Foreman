package ru.goryachev.foreman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.goryachev.foreman.dao.AppUsersDAO;
import ru.goryachev.foreman.entities.AppUser;
import ru.goryachev.foreman.entities.Entity;
import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUsersDAO appUsersDAO;

    public List<AppUser> getAll() {
        return appUsersDAO.getAll();
    }

    public void create(Entity entity) {
        appUsersDAO.create(entity);
    }

    public void update(Entity entity) {
        appUsersDAO.update(entity);
    }

    public void delete(int id) {
        appUsersDAO.delete(id);
    }

    public AppUser getById(int id) {
        return appUsersDAO.getById(id);
    }

    public AppUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Object obj = auth.getPrincipal();
        String userLogin = "";

        if (obj instanceof UserDetails) {
            userLogin = ((UserDetails) obj).getUsername();
        } else {
            userLogin = obj.toString();
        }

        AppUser currentAppUser = appUsersDAO.getByLogin(userLogin);
        return currentAppUser;
    }
}
