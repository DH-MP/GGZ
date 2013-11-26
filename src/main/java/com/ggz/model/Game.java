package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;
import com.sunnyd.annotations.ActiveRelationManyToMany;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class Game extends Base implements IModel
{
    //Table attributes
    @ActiveRecordField
    private Double price;

    @ActiveRecordField
    private Integer rating;

    @ActiveRecordField
    private String name;

    @ActiveRecordField
    private String releaseDate;

    @ActiveRecordField
    private String deck;

    @ActiveRecordField
    private String description;

    @ActiveRecordField
    private String apiDetailUrl;

    //Relation
    @ActiveRecordField
    private Integer apiId;

    @ActiveRelationManyToMany(relationTable = "games_developers")
    private List<Developer> developers;


    public Game() {
        super();
    }

    public Game(Map<String, Object> HM) {
        super(HM);
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
        setUpdateFlag(true);
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
        setUpdateFlag(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setUpdateFlag(true);
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        setUpdateFlag(true);
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
        setUpdateFlag(true);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        setUpdateFlag(true);
    }

    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public void setApiDetailUrl(String apiDetailUrl) {
        this.apiDetailUrl = apiDetailUrl;
        setUpdateFlag(true);
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
        setUpdateFlag(true);
    }


    public static void main(String[] args) {
        Game c = new Game().find(1);
        System.out.println(c.getDevelopers());
    }

    public List<Developer> getDevelopers() {
        initRelation("developers");
        return this.developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }



}
