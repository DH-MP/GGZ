package com.ggz.model.activejdbc;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/20/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Inventory{

    private Inventory g;

    //Singleton
    public Inventory Inventory()
    {
        if(this.g == null){
            this.g = new Inventory();
        }
        return this.g;
    }

    public Map<String, LazyList<Model>> getItems(){
        LazyList<Model> consoles = Console.findAll();
        LazyList<Model> games = Game.findAll();
        Map<String, LazyList<Model>> items = new HashMap<String, LazyList<Model>>();
        items.put("consoles", consoles);
        items.put("games", games);
        return items;
    }

}
