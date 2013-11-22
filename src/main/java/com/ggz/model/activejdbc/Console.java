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
 * Date: 11/21/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Console extends Model {
    public Console() {
    }


    public double getPrice()
    {
        return this.getDouble("price");
    }

    public int getRating()
    {
        return this.getInteger("rating");
    }

    public int getApiId()
    {
        return this.getInteger("api_id");
    }

    public String getName()
    {
        return this.getString("name");
    }

    public Timestamp getReleaseDate()
    {
        return this.getTimestamp("release_date");
    }

    public String getDeck()
    {
        return this.getString("deck");
    }

    public String getDescription()
    {
        return this.getString("description");
    }

    public String getApiDetailUrl()
    {
        return this.getString("api_detail_url");
    }

    public Image getImage()
    {
        LazyList<Image> img = this.getAll(Image.class);
        if (img.size() < 1)
            return new Image();
        else
            return new Image(img.get(0));
    }
}
