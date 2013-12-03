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

  //    @ActiveRecordField
//    private String description;
  @ActiveRecordField
  private String apiDetailUrl;
  @ActiveRecordField
  private Integer quantity;
  //Relation
  @ActiveRecordField
  private Integer apiId;
  @ActiveRelationManyToMany(relationTable = "games_developers")
  private List<Developer> developers;
  //Relation
  @ActiveRecordField
  private Integer imageId;
  @ActiveRelationHasOne
  private Image image;
  @ActiveRecordField
  private Integer platformId;
  @ActiveRelationHasOne
  private Platform platform;
  @ActiveRecordField
  private Integer pgRatingId;
  @ActiveRelationHasOne
  private PgRating pgRating;

  public Game()
  {
    super();
  }

  public Game(Map<String, Object> HM)
  {
    super(HM);
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

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//        setUpdateFlag(true);
//    }

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

  public void setDevelopers(List<Developer> developers)
  {
    this.developers = developers;
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

  public Integer getPlatformId()
  {
    return platformId;
  }

  public void setPlatformId(Integer platformId)
  {
    this.platformId = platformId;
    setUpdateFlag(true);
  }

  public Platform getPlatform()
  {
    return platform;
  }

  public void setPlatform(Platform platform)
  {
    this.platform = null;
    this.platformId = platform.getId();
    setUpdateFlag(true);
  }

  public Integer getPgRatingId()
  {
    return pgRatingId;
  }

  public void setPgRatingId(Integer pgRatingId)
  {
    this.pgRatingId = pgRatingId;
    setUpdateFlag(true);
  }

  public PgRating getPgRating()
  {
    return pgRating;
  }

  public void setPgRating(PgRating pgRating)
  {
    this.pgRating = null;
    this.pgRatingId = pgRating.getId();
    this.pgRating = pgRating;
  }

//    public static void main(String [ ] args){
//      List<Game> games = new ArrayList<Game>();
//      Game a = new Game().find(1);
//      games.add(a);
//
//      Game b = new Game().find(1);
//      games.add(b);
//
//      Object[] gameArray = games.toArray();
//      for(Object game : games.toArray()){
//          Game g = (Game) game;
//          if(g.getId() == 1){
//            System.out.println(g);
//            System.out.println(new Game());
//
//          }
//      }
//    }
}
