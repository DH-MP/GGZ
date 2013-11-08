package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Model;

public class PgRating extends Model
{
  private PgRating pgRating;
  public PgRating() {}
  public PgRating(PgRating d) { this.pgRating = d; }
  public String getName() { return pgRating.getString("name"); }
}
