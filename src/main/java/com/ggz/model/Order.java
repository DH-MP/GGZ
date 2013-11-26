package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;

import java.security.Timestamp;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 11/20/13
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Order  extends Base implements IModel {

    @ActiveRecordField
    private String status;

    @ActiveRecordField
    private Timestamp orderDate;

    @ActiveRecordField
    private Integer userId;

    @ActiveRecordField
    private Integer shoppingCartId;

    @ActiveRelationHasOne
    private User user;

    @ActiveRelationHasOne
    private ShoppingCart shoppingCart;

    public Order() {
        super();
    }

    public Order(Map<String, Object> HM) {
        super(HM);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        setUpdateFlag(true);
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        setUpdateFlag(true);
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
        setUpdateFlag(true);
    }

    public User getUser(){
        initRelation("user");
        return this.user;
    }

    public void setUser(User user){
        this.user = null;
        this.userId = user.getId();
        setUpdateFlag(true);
    }
    public ShoppingCart getShoppingCart(){
        initRelation("shoppingCart");
        return this.shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart){
        this.shoppingCart = null;
        this.shoppingCartId = shoppingCart.getId();
        setUpdateFlag(true);
    }
}
