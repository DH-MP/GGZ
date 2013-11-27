package com.ggz.model;

import com.ggz.model.Inventory;
import com.ggz.model.User;
import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;
import com.sunnyd.annotations.ActiveRelationManyToMany;

import java.util.List;
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

    @ActiveRelationManyToMany(relationTable = "games_shopping_carts")
    private List<Game> games;

    @ActiveRelationManyToMany(relationTable = "consoles_shopping_carts")
    private List<Console> consoles;

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


    public List<Game> getGames(){
        initRelation("games");
        return this.games;
    }

    public void  setGames(List<Game> games){
        this.games = games;
        setUpdateFlag(true);
    }

    public List<Console> getConsoles(){
        initRelation("consoles");
        return this.consoles;
    }

    public void  setConsoles(List<Console> consoles){
        this.consoles = consoles;
        setUpdateFlag(true);
    }

}
