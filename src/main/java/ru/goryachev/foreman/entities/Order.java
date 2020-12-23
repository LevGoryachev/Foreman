package ru.goryachev.foreman.entities;

import java.time.LocalDateTime;

public class Order implements Entity {

    private int id;
    private int constructionId;
    private LocalDateTime ordertime;
    private boolean posted;
    private boolean sent;
    private boolean statusExecuted;
    private int appUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(int constructionId) {
        this.constructionId = constructionId;
    }

    public LocalDateTime getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(LocalDateTime ordertime) {
        if (ordertime == null) {
            this.ordertime = LocalDateTime.of(0, 0, 0, 0, 0);
        }
        this.ordertime = ordertime;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public boolean isStatusExecuted() {
        return statusExecuted;
    }

    public void setStatusExecuted(boolean statusExecuted) {
        this.statusExecuted = statusExecuted;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }
}
