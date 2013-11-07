package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("activejdbcgames")
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

  private ActiveJDBCImage imagesUrl;

  private List<ActiveJDBCDeveloper> developers;
  private List<ActiveJDBCPGRating> pgRating;
  private List<ActiveJDBCPlatform> platforms;

//  public double getPrice()
//  {
//    return price;
//  }
//
//  public void setPrice(double price)
//  {
//    this.price = price;
//  }
//
//  public int getRating()
//  {
//    return rating;
//  }
//
//  public void setRating(int rating)
//  {
//    this.rating = rating;
//  }
//
//  public String getApiDetailUrl()
//  {
//    return apiDetailUrl;
//  }
//
//  public void setApiDetailUrl(String apiDetailUrl)
//  {
//    this.apiDetailUrl = apiDetailUrl;
//  }
//
//  public String getDeck()
//  {
//    return deck;
//  }
//
//  public void setDeck(String deck)
//  {
//    this.deck = deck;
//  }
//
//  public String getDescription()
//  {
//    return description;
//  }
//
//  public void setDescription(String description)
//  {
//    this.description = description;
//  }
//
//  public List<ActiveJDBCDeveloper> getDevelopers()
//  {
//    return developers;
//  }
//
//  public void setDevelopers(List<ActiveJDBCDeveloper> developers)
//  {
//    this.developers = developers;
//  }
//
//  public int getApiId()
//  {
//    return apiId;
//  }
//
//  public void setApiId(int apiId)
//  {
//    this.apiId = apiId;
//  }
//
//  public ActiveJDBCImage getImagesUrl()
//  {
//    return imagesUrl;
//  }
//
//  public void setImagesUrl(ActiveJDBCImage imagesUrl)
//  {
//    this.imagesUrl = imagesUrl;
//  }
//
//  public String getName()
//  {
//    return name;
//  }
//
//  public void setName(String name)
//  {
//    this.name = name;
//  }
//
//  public String getReleaseDate()
//  {
//    return releaseDate;
//  }
//
//  public void setReleaseDate(String releaseDate)
//  {
//    this.releaseDate = releaseDate;
//  }
//
//  public List<ActiveJDBCPGRating> getPgRating()
//  {
//    return pgRating;
//  }
//
//  public void setPgRating(List<ActiveJDBCPGRating> pgRating)
//  {
//    this.pgRating = pgRating;
//  }
//
//  public List<ActiveJDBCPlatform> getPlatforms()
//  {
//    return platforms;
//  }
//
//  public void setPlatforms(List<ActiveJDBCPlatform> platforms)
//  {
//    this.platforms = platforms;
//  }

  @Override
  public String toString()
  {
    return this.name;
  }
}
