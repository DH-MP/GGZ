package com.ggz.model;

import com.ggz.model.Inventory;
import com.ggz.model.User;
import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 11/20/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCart extends Base implements IModel {

    //Table attributes
    @ActiveRecordField
    private Double totalPrice;

    @ActiveRecordField
    private Integer quantity;

    @ActiveRecordField
    public Integer userId;

    @ActiveRelationHasOne
    private User user;

    public ShoppingCart() {
        super();
    }

    public ShoppingCart(Map<String, Object> HM) {
        super(HM);
    }


    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        setUpdateFlag(true);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        setUpdateFlag(true);
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        setUpdateFlag(true);
    }

    public User getUser() {
        initRelation("user");
        return this.user;
    }

    public void setUser(User user) {
        this.user = null;
        this.userId = user.getId();
        setUpdateFlag(true);
    }
}
