package ru.goryachev.foreman.entities;

public class BillPosition implements Entity {

    private int constructionid;
    private int materialid;
    private int billqty ;

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

    public int getBillqty() {
        return billqty;
    }

    public void setBillqty(int billqty) {
        this.billqty = billqty;
    }
}
