package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Model;

public class Image extends Model
{
  private String smallThumb;
  private String mediumThumb;
  private String largeThumb;

  public Image()
  {
    smallThumb = "";
    mediumThumb = "";
    largeThumb = "";
  }

  public Image(Image d)
  {
    smallThumb = d.getString("tiny_url");
    mediumThumb = d.getString("medium_url");
    largeThumb = d.getString("large_url");
  }

  public String getLargeThumb() { return largeThumb; }
  public String getMediumThumb() { return mediumThumb; }
  public String getSmallThumb() { return smallThumb; }
}
