package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasOne;
import com.sunnyd.annotations.ActiveRelationManyToMany;

import java.util.List;
import java.util.Map;

public class Game extends Base implements IModel
{
  //Table attributes
  @ActiveRecordField
  private Double price;
  @ActiveRecordField
  private Integer rating;
  @ActiveRecordField
  private String name;
  @ActiveRecordField
  private String releaseDate;
  @ActiveRecordField
  private String deck;
  @ActiveRecordField
  private String description;
  @ActiveRecordField
  private String apiDetailUrl;
  @ActiveRecordField
  private Integer quantity;
  //Relation
  @ActiveRecordField
  private Integer apiId;
  @ActiveRelationManyToMany(relationTable = "games_developers")
  private List<Developer> developers;
  @ActiveRelationManyToMany(relationTable = "games_platforms")
  private List<Platform> platforms;
  //Relation
  @ActiveRecordField
  private Integer imageId;
  @ActiveRelationHasOne
  private Image image;


  public Game()
  {
    super();
  }

  public Game(Map<String, Object> HM)
  {
    super(HM);
  }

  public static void main(String[] args)
  {
    Game c = new Game().find(1);
    System.out.println(c.getDevelopers());
  }

  public Double getPrice()
  {
    return price;
  }

  public void setPrice(Double price)
  {
    this.price = price;
    setUpdateFlag(true);
  }

  public Integer getRating()
  {
    return rating;
  }

  public void setRating(Integer rating)
  {
    this.rating = rating;
    setUpdateFlag(true);
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
    setUpdateFlag(true);
  }

  public String getReleaseDate()
  {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate)
  {
    this.releaseDate = releaseDate;
    setUpdateFlag(true);
  }

  public String getDeck()
  {
    return deck;
  }

  public void setDeck(String deck)
  {
    this.deck = deck;
    setUpdateFlag(true);
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
    setUpdateFlag(true);
  }

  public String getApiDetailUrl()
  {
    return apiDetailUrl;
  }

  public void setApiDetailUrl(String apiDetailUrl)
  {
    this.apiDetailUrl = apiDetailUrl;
    setUpdateFlag(true);
  }

  public Integer getApiId()
  {
    return apiId;
  }

  public void setApiId(Integer apiId)
  {
    this.apiId = apiId;
    setUpdateFlag(true);
  }

  public List<Developer> getDevelopers()
  {
    initRelation("developers");
    return this.developers;
  }

  public List<Platform> getPlatforms()
  {
    initRelation("platforms");
    return this.platforms;
  }

  public Integer getImageId()
  {
    return imageId;
  }

  public void setImageId(Integer imageId)
  {
    this.imageId = imageId;
    setUpdateFlag(true);
  }

  public Image getImage()
  {
    initRelation("image");
    return this.image;
  }

  public void setImage(Image image)
  {
    this.image = null;
    this.imageId = image.getId();
    setUpdateFlag(true);
  }

  public Integer getQuantity()
  {
    return quantity;
  }

  public void setQuantity(Integer quantity)
  {
    this.quantity = quantity;
    setUpdateFlag(true);
  }
}
