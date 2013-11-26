package com.ggz.model;

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 11/20/13
 * Time: 7:40 PM
 * To change this template use File | Settings | File Templates.
 */
import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasMany;
import com.sunnyd.annotations.ActiveRelationHasOne;

import java.util.List;
import java.util.Map;

public class User extends Base implements IModel{

    //Table attributes
    @ActiveRecordField
    private String firstName;

    @ActiveRecordField
    private String lastName;

    @ActiveRecordField
    private String address;

    @ActiveRecordField
    private String userName;

    @ActiveRecordField
    private String password;

    @ActiveRecordField
    public Integer inventoryId;

    @ActiveRecordField
    public Integer shoppingCartId;

    @ActiveRelationHasOne
    private Inventory inventory;

    @ActiveRelationHasOne
    private ShoppingCart shoppingCart;

    @ActiveRelationHasMany
    private List<Payment> payments;

    @ActiveRelationHasMany
    private List<CreditCard> creditCards;

    public User() {
        super();
    }

    public User(Map<String, Object> HM) {
        super(HM);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setUpdateFlag(true);
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setUpdateFlag(true);
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
        setUpdateFlag(true);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        setUpdateFlag(true);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        setUpdateFlag(true);
    }

    public Integer getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
        setUpdateFlag(true);
    }

    public Integer getShoppingCartId() {
        return this.shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
        setUpdateFlag(true);
    }

    public Inventory getInventory() {
        initRelation("inventory");
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = null;
        this.inventoryId = inventory.getId();
        setUpdateFlag(true);
    }

    public ShoppingCart getShoppingCart() {
        initRelation("shoppingCart");
        return this.shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = null;
        this.shoppingCartId = shoppingCart.getId();
        setUpdateFlag(true);
    }

    public List<Payment> getPayments()
    {
        initRelation("payments");
        return this.payments;
    }

    public void setPayments(List<Payment> payments)
    {
        this.payments = payments;
    }

    public List<CreditCard> getCreditCards()
    {
        initRelation("creditCards");
        return this.creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards)
    {
        this.creditCards = creditCards;
    }
}
