package ru.goryachev.foreman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.foreman.entities.AppUser;
import ru.goryachev.foreman.entities.Role;
import ru.goryachev.foreman.service.AppUserService;
import ru.goryachev.foreman.service.RoleService;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    public RoleService roleService;

    @Autowired
    public AppUserService appUserService;

    @GetMapping ("/admin")
    public String adminPanel () {
        return "admin_panel";
    }


    //CRUD: roles
    //read: roles
    @GetMapping ("/roles-editable")
    public String rolesEditable (Model model) {
        model.addAttribute("rolesList", roleService.getAll());
        return "roles_edit";
    }

    //create: roles
    @PostMapping("/roles/add")
    public String addroles (@ModelAttribute("role") Role role) {
        roleService.save(role);
        return "redirect:/roles-editable";
    }

    //delete: roles
    @GetMapping ("/roles/del/{id}")
    public String delroles (@PathVariable("id") int id) {
        roleService.delete(id);
        return "redirect:/roles-editable";
    }


    //CRUD: users
    //read: users
    @GetMapping ("/users-editable")
    public String usersEditable (Model model) {
        model.addAttribute("userList", appUserService.getAll());
        return "users_edit";
    }

    //create: users
    @PostMapping("/users/add")
    public String addUsers (@ModelAttribute("appUserAttr") AppUser appUser) {
        appUserService.save(appUser);
    return "redirect:/users-editable";
    }

    //update: users
    @GetMapping ("/users/edit/{id}")
    public String editUser (@PathVariable("id") int id, Model model) {
        model.addAttribute("userEdit", appUserService.getById(id));
        return "user_edit";
    }
    @PostMapping ("/users/upd")
    public String updateUser (@ModelAttribute ("appUserAttr") AppUser appUser) {
        appUserService.update(appUser);
        return "redirect:/users-editable";
    }

    //delete: users
    @GetMapping ("/users/del/{id}")
    public String delUsers (@PathVariable("id") int id) {
        appUserService.delete(id);
        return "redirect:/users-editable";
    }
}
