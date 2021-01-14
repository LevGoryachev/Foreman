package ru.goryachev.foreman.dto;

import ru.goryachev.foreman.entities.Entity;

public class OrderPositionDTO implements Entity {

    private int constructionId;
    private int materialId;
    private int orderId;
    private String constructionName;
    private String materialName;
    private int orderqty;

    public int getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(int constructionId) {
        this.constructionId = constructionId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        if (constructionName == null) {
            this.constructionName = "";
        }
        this.constructionName = constructionName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        if (materialName == null) {
            this.materialName = "";
        }
        this.materialName = materialName;
    }

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }
}


