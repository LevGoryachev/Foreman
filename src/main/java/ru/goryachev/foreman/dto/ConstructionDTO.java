package ru.goryachev.foreman.dto;

public class ConstructionDTO {

    private int id;
    private String codenumber;
    private String name;
    private String description;
    private String urlName;

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

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        if (urlName == null) {
            this.urlName = "";
        }
        this.urlName = urlName;
    }
}
