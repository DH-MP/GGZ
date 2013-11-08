package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Model;

public class Image extends Model
{
  private Image image;
  public Image() {}
  public Image(Image d) { this.image = d; }
  public String getName() { return image.getString("name"); }
}
