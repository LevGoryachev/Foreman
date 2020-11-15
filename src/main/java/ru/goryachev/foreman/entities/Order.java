package ru.goryachev.foreman.entities;

import java.util.Date;

public class Order implements Entity {

    int id;
    Date ordertime;
    String status;
    int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        if (ordertime == null) {
            this.ordertime = new Date(0);
        }
        this.ordertime = ordertime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null) {
            this.status = "";
        }
        this.status = status;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
