package ru.goryachev.foreman.entities;

import java.time.LocalDateTime;

public class OrderPresentable {

    private int id;
    private LocalDateTime orderTime;
    private String constructionName;
    private String appUserLastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getAppUserLastName() {
        return appUserLastName;
    }

    public void setAppUserLastName(String appUserLastName) {
        this.appUserLastName = appUserLastName;
    }
}
