package ru.goryachev.foreman.entities;

public class Material implements Entity {

    private int id;
    private String name;
    private String um;
    private int unitWkg;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            this.name = "";
        }
        this.name = name;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        if (um == null) {
            this.um = "";
        }
        this.um = um;
    }

    public int getUnitWkg() {
        return unitWkg;
    }

    public void setUnitWkg(int unitWkg) {
        this.unitWkg = unitWkg;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (notes == null) {
            this.notes = "";
        }
        this.notes = notes;
    }
}
