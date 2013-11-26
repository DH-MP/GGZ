package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 11/20/13
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreditCard  extends Base implements IModel {


    //Table attributes
    @ActiveRecordField
    private Integer ccNumber;


    //Relation
    @ActiveRecordField
    private Integer userId;
    @ActiveRelationHasOne
    private User user;


    public CreditCard() {
        super();
    }

    public CreditCard(Map<String, Object> HM) {
        super(HM);
    }

    public Integer getCcNumber() {
        return this.ccNumber;
    }

    public void setCcNumber(Integer ccNumber) {
        this.ccNumber = ccNumber;
        setUpdateFlag(true);
    }


    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        setUpdateFlag(true);
    }


    public User getUser(){
        initRelation("user");
        return this.user;
    }

    public void setPlatform(User user){
        this.user = null;
        this.userId = user.getId();
        setUpdateFlag(true);
    }






}
