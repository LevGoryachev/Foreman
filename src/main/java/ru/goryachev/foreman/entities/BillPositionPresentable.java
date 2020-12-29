package ru.goryachev.foreman.entities;

public class BillPositionPresentable implements Entity {

    private int constructionId;
    private String ConstructionName;    //join with "construction"
    private String ConstructionCodeNumber;    //join with "construction"
    private int materialId;
    private String MaterialName;        //join with "material"
    private String MaterialUm;          //join with "material"
    private int MaterialUnitWkg;        //join with "material"
    private String MaterialNotes;       //join with "material"
    private int billqty ;

}
