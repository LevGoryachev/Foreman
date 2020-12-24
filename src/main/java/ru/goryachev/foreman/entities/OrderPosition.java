package ru.goryachev.foreman.entities;

public class OrderPosition implements Entity {

    private int constructionid;
    private int materialid;
    private int orderid;
    private boolean statusDelivered;
    private int orderqty;

    public int getConstructionid() {
        return constructionid;
    }

    public void setConstructionid(int constructionid) {
        this.constructionid = constructionid;
    }

    public int getMaterialid() {
        return materialid;
    }

    public void setMaterialid(int materialid) {
        this.materialid = materialid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public boolean isStatusDelivered() {
        return statusDelivered;
    }

    public void setStatusDelivered(boolean statusDelivered) {
        this.statusDelivered = statusDelivered;
    }

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }
}
