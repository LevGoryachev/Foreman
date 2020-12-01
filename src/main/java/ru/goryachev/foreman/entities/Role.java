package ru.goryachev.foreman.entities;

public class Role implements Entity {

    private int id;
    private String rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        if (rank == null) {
            this.rank = "";
        }
        this.rank = rank;
    }
}
