package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.IModel;

public class Game extends Base implements IModel
{
//  public Game() {}
//
//  public double getPrice()
//  {
//    return this.getDouble("price");
//  }
//
//  public int getRating()
//  {
//    return this.getInteger("rating");
//  }
//
//  public int getApiId()
//  {
//    return this.getInteger("api_id");
//  }
//
//  public String getName()
//  {
//    return this.getString("name");
//  }
//
//  public Timestamp getReleaseDate()
//  {
//    return this.getTimestamp("release_date");
//  }
//
//  public String getDeck()
//  {
//    return this.getString("deck");
//  }
//
//  public String getDescription()
//  {
//    return this.getString("description");
//  }
//
//  public String getApiDetailUrl()
//  {
//    return this.getString("api_detail_url");
//  }
//
//  public Image getImage()
//  {
//    LazyList<Image> img = this.getAll(Image.class);
//    if (img.size() < 1)
//      return new Image();
//    else
//      return new Image(img.get(0));
//  }
//
//  public List<Developer> getDevelopers()
//  {
//    return this.getGenericManyToMany(Developer.class);
//  }
//
//  public List<Platform> getPlatforms()
//  {
//    return this.getGenericManyToMany(Platform.class);
//  }
//
//  public List<PgRating> getPgRating()
//  {
//    return this.getGenericManyToMany(PgRating.class);
//  }
//
//  private <T extends Model> List<T> getGenericManyToMany(Class<T> clazz)
//  {
//
//    List<T> castedList = new ArrayList<T>();
//
//    try
//    {
//      List<T> lists = this.getAll(clazz);
//      Constructor<?> c = clazz.getConstructor(clazz);
//      for (Object t : lists)
//      {
//        castedList.add((T)c.newInstance(t));
//      }
//    }
//    catch (NoSuchMethodException e)
//    {
//    }
//    catch (InvocationTargetException e)
//    {
//    }
//    catch (InstantiationException e)
//    {
//    }
//    catch (IllegalAccessException e)
//    {
//    }
//
//    return castedList;
//  }
}
