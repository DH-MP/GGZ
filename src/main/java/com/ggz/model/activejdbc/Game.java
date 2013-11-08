package com.ggz.model.activejdbc;

import org.codehaus.plexus.util.StringUtils;
import org.javalite.activejdbc.Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Game extends Model
{
  private Game g;

  public Game() {}

  public Game(Model g)
  {
    this.g = (Game)g;
  }

  public double getPrice()
  {
    return g.getDouble("price");
  }

  public int getRating()
  {
    return g.getInteger("rating");
  }

  public int getApiId()
  {
    return g.getInteger("api_id");
  }

  public String getName()
  {
    return g.getString("name");
  }

  public Timestamp getReleaseDate()
  {
    return g.getTimestamp("release_date");
  }

  public String getDeck()
  {
    return g.getString("deck");
  }

  public String getDescription()
  {
    return g.getString("description");
  }

  public String getApiDetailUrl()
  {
    return g.getString("api_detail_url");
  }

  public Image getImage()
  {
    List<Image> list = g.get(Image.class, "images");
    if (list.size() == 0)
      throw new RuntimeException("No image associated with this game.");
    if (list.size() > 1)
      throw new RuntimeException("More than 1 image associated with this game.");

    List<Image> realImage = new ArrayList<Image>(list.size());
    for (Image i : list)
      realImage.add(new Image(i));

    return realImage.get(0);
  }

  public List<Developer> getDevelopers()
  {
    return this.getGenericManyToMany(Developer.class);
  }

  public List<Platform> getPlatforms()
  {
    return this.getGenericManyToMany(Platform.class);
  }

  public List<PgRating> getPgRating()
  {
    return this.getGenericManyToMany(PgRating.class);
  }

  private <T extends Model> List<T> getGenericManyToMany(Class<T> clazz)
  {

    List<T> castedList = null;

    try
    {
      List<T> lists = g.getAll(clazz);
      castedList = new ArrayList<T>(lists.size());
      Constructor<?> c = clazz.getConstructor(clazz);

      for (Object t : lists)
      {
        castedList.add((T)c.newInstance(t));
      }
    }
    catch (NoSuchMethodException e)
    {
    }
    catch (InvocationTargetException e)
    {
    }
    catch (InstantiationException e)
    {
    }
    catch (IllegalAccessException e)
    {
    }

    return castedList;
  }
}
