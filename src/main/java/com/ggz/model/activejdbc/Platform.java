package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Model;

public class Platform extends Model
{
  private Platform platform;
  public Platform() {}
  public Platform(Platform d) { this.platform = d; }
  public String getName() { return platform.getString("name"); }
}
