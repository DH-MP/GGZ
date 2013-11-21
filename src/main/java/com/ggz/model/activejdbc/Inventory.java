package com.ggz.model.activejdbc;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/20/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Inventory extends Model{

    private Inventory g;

    public Inventory() {}

    public Inventory(Model g)
    {
        this.g = (Inventory)g;
    }

    public LazyList<Game> getItems(){
        return this.getAll(Game.class);
    }
}
