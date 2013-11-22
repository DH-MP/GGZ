package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 11/20/13
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Item extends Model{

    public Item() {}

    public Integer getId()
    {
        return getInteger("id");
    }
    public String getItemName()
    {

        return getString("item_name");
    }

    public String getDescription()
    {
        return getString("Description");
    }


    public int getPrice()
    {
        return getInteger("price");
    }

    public int getQuantity(){
        return getInteger("quantity");
    }

}
