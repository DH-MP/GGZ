package com.ggz.model;


import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;

import java.util.Map;

public class Image extends Base implements IModel
{

    @ActiveRecordField
    private String tinyURL;

    @ActiveRecordField
    private String mediumURL;


    @ActiveRecordField
    private String largeURL;


    //Relation
    @ActiveRecordField
    private Integer gameId;
    @ActiveRelationHasOne
    private Game game;






    public Image() {
        super();
    }

    public Image(Map<String, Object> HM) {
        super(HM);
    }



    public String getTinyURL() {
        return tinyURL;
    }

    public void setTinyURL(String tinyURL) {
        this.tinyURL = tinyURL;
        setUpdateFlag(true);
    }

    public String getMediumURL() {
        return mediumURL;

    }

    public void setMediumURL(String mediumURL) {
        this.mediumURL = mediumURL;
        setUpdateFlag(true);
    }

    public String getLargeURL() {
        return largeURL;
    }

    public void setLargeURL(String largeURL) {
        this.largeURL = largeURL;
        setUpdateFlag(true);
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
        setUpdateFlag(true);
    }


    public Game getGame(){
        initRelation("game");
        return this.game;
    }

    public void setGame(Game game){
        this.game = null;
        this.gameId = game.getId();
        setUpdateFlag(true);
    }



}
