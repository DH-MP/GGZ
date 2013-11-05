package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Model;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: snw
 * Date: 11/4/2013
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActiveJDBCGame extends Model
{
  // none api attributes
  private double price;
  private int rating; // out of 10, but only 5 stars

  // api attributes
  private int apiId;
  private String name;
  private String releaseDate;
  private String deck; // short description
  private String description; // very large html embedded description
  private String apiDetailUrl;

  private Map<String, String> imagesUrl; // map of images size (large, medium, small)
  private List<String> developers;
  private List<String> pgRating;
  private List<String> platforms;

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public int getRating()
  {
    return rating;
  }

  public void setRating(int rating)
  {
    this.rating = rating;
  }

  public String getApiDetailUrl()
  {
    return apiDetailUrl;
  }

  public void setApiDetailUrl(String apiDetailUrl)
  {
    this.apiDetailUrl = apiDetailUrl;
  }

  public String getDeck()
  {
    return deck;
  }

  public void setDeck(String deck)
  {
    this.deck = deck;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public List<String> getDevelopers()
  {
    return developers;
  }

  public void setDevelopers(List<String> developers)
  {
    this.developers = developers;
  }

  public int getApiId()
  {
    return apiId;
  }

  public void setApiId(int apiId)
  {
    this.apiId = apiId;
  }

  public Map<String, String> getImagesUrl()
  {
    return imagesUrl;
  }

  public void setImagesUrl(Map<String, String> imagesUrl)
  {
    this.imagesUrl = imagesUrl;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getReleaseDate()
  {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate)
  {
    this.releaseDate = releaseDate;
  }

  public List<String> getPgRating()
  {
    return pgRating;
  }

  public void setPgRating(List<String> pgRating)
  {
    this.pgRating = pgRating;
  }

  public List<String> getPlatforms()
  {
    return platforms;
  }

  public void setPlatforms(List<String> platforms)
  {
    this.platforms = platforms;
  }

  @Override
  public String toString()
  {
    return this.name;
  }
}
