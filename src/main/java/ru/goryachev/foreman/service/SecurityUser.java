package ru.goryachev.foreman.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.goryachev.foreman.entities.AppUser;

import java.util.Collection;

public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final boolean isActive;

    public SecurityUser(String username, String password, boolean isActive) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

//    public static UserDetails fromAppUser (AppUser appUser) {
//
//        return new org.springframework.security.core.userdetails.User(
//                appUser.getNickName(), appUser.getPassword(), true);
//    }

}
