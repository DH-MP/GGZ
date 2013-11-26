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
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Payment extends Base implements IModel{

    //Table attributes
    @ActiveRecordField
    private Double amount;

    @ActiveRecordField
    private Integer userId;

    @ActiveRecordField
    private Integer orderId;

    @ActiveRelationHasOne
    private User user;

    @ActiveRelationHasOne
    private Order order;

    public Payment() {
        super();
    }

    public Payment(Map<String, Object> HM) {
        super(HM);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
        setUpdateFlag(true);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        setUpdateFlag(true);
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
    public Order getOrder(){
        initRelation("order");
        return this.order;
    }

    public void setOrder(Order order){
        this.order = null;
        this.orderId = order.getId();
        setUpdateFlag(true);
    }


}
