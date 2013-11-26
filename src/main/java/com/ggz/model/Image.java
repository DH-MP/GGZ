package com.ggz.model;


import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;

import java.util.Map;

public class Image extends Base implements IModel
{

    @ActiveRecordField
    private String tinyUrl;

    @ActiveRecordField
    private String mediumUrl;


    @ActiveRecordField
    private String largeUrl;


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



    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
        setUpdateFlag(true);
    }

    public String getMediumUrl() {
        return mediumUrl;

    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
        setUpdateFlag(true);
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
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
