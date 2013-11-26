package com.ggz.model;
import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/21/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Console extends Base implements IModel {

    //Table attributes
    @ActiveRecordField
    private Double price;

    @ActiveRecordField
    private String description;

    @ActiveRecordField
    private String apiDetailUrl;

    //Declare Relation
    @ActiveRecordField
    private Integer apiId;


    @ActiveRecordField
    public Integer platformId;
    @ActiveRelationHasOne
    private Platform platform;

    public Console() {
        super();
    }

    public Console(Map<String, Object> HM) {
        super(HM);
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
        setUpdateFlag(true);
    }

    public String getDescription() {
        return this.description;
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
        return this.apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
        setUpdateFlag(true);
    }

    public Integer getPlatformId() {
        return this.platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
        setUpdateFlag(true);
    }


    public Platform getPlatform(){
        initRelation("platform");
        return this.platform;
    }

    public void setPlatform(Platform platform){
        this.platform = null;
        this.platformId = platform.getId();
        setUpdateFlag(true);
    }

}
