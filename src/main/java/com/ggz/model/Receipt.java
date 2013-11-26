package com.ggz.model.activejdbc;

import com.ggz.model.Inventory;
import com.ggz.model.Payment;
import com.ggz.model.User;
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
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Receipt extends Base implements IModel {

    //Table attributes
    @ActiveRecordField
    private Double amount;

    @ActiveRecordField
    private Timestamp receiptDate;

    @ActiveRecordField
    private Integer paymentId;

    @ActiveRecordField
    private Integer userId;

    @ActiveRelationHasOne
    private User user;

    @ActiveRelationHasOne
    private Payment payment;

    public Receipt() {
        super();
    }

    public Receipt(Map<String, Object> HM) {
        super(HM);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
        setUpdateFlag(true);
    }

    public Timestamp getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Timestamp receiptDate) {
        this.receiptDate = receiptDate;
        setUpdateFlag(true);
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
        setUpdateFlag(true);
    }

    public Integer getUserId() {
        return userId;
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
    public Payment getPayment() {
        initRelation("payment");
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = null;
        this.paymentId = payment.getId();
        setUpdateFlag(true);
    }
}
