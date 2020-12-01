package ru.goryachev.foreman.entities;

public class BillPosition implements Entity {

    private int constructionId;
    private int materialId;
    private int billqty ;

    //fields for JOIN (other tables):
    private int entityConstructionId;    //join with "construction"
    private String entityConstructionName;    //join with "construction"
    private String entityConstructionCodeNumber;    //join with "construction"

    private String entityMaterialName;        //join with "material"
    private String entityMaterialUm;          //join with "material"
    private int entityMaterialUnitWkg;        //join with "material"
    private String entityMaterialNotes;       //join with "material"

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

    public int getBillqty() {
        return billqty;
    }

    public void setBillqty(int billqty) {
        this.billqty = billqty;
    }

    public int getEntityConstructionId() {
        return entityConstructionId;
    }

    public void setEntityConstructionId(int entityConstructionId) {
        this.entityConstructionId = entityConstructionId;
    }

    public String getEntityConstructionName() {
        return entityConstructionName;
    }

    public void setEntityConstructionName(String entityConstructionName) {
        if (entityConstructionName == null) {
            this.entityConstructionName = "";
        }
        this.entityConstructionName = entityConstructionName;
    }

    public String getEntityConstructionCodeNumber() {
        return entityConstructionCodeNumber;
    }

    public void setEntityConstructionCodeNumber(String entityConstructionCodeNumber) {
        if (entityConstructionCodeNumber == null) {
            this.entityConstructionCodeNumber = "";
        }
        this.entityConstructionCodeNumber = entityConstructionCodeNumber;
    }

    public String getEntityMaterialName() {
        return entityMaterialName;
    }

    public void setEntityMaterialName(String entityMaterialName) {
        if (entityMaterialName == null) {
            this.entityMaterialName = "";
        }
        this.entityMaterialName = entityMaterialName;
    }

    public String getEntityMaterialUm() {
        return entityMaterialUm;
    }

    public void setEntityMaterialUm(String entityMaterialUm) {
        if (entityMaterialUm == null) {
            this.entityMaterialUm = "";
        }
        this.entityMaterialUm = entityMaterialUm;
    }

    public int getEntityMaterialUnitWkg() {
        return entityMaterialUnitWkg;
    }

    public void setEntityMaterialUnitWkg(int entityMaterialUnitWkg) {
        this.entityMaterialUnitWkg = entityMaterialUnitWkg;
    }

    public String getEntityMaterialNotes() {
        return entityMaterialNotes;
    }

    public void setEntityMaterialNotes(String entityMaterialNotes) {
        if (entityMaterialNotes == null) {
            this.entityMaterialNotes = "";
        }
        this.entityMaterialNotes = entityMaterialNotes;
    }
}
