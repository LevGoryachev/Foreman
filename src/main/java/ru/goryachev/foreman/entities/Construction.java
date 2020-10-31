package ru.goryachev.foreman.entities;

public class Construction {

    private int id;
    private String codenumber;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodenumber() {
        return codenumber;
    }

    public void setCodenumber(String codenumber) {
        if (codenumber == null) {
            this.codenumber = "";
        }
        this.codenumber = codenumber;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) {
            this.description = "";
        }
        this.description = description;
    }
}
