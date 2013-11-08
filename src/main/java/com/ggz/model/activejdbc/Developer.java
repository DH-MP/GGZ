package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

public class Developer extends Model
{
  private Developer d;
  public Developer() {}
  public Developer(Developer d) { this.d = d; }
  public String getName() { return d.getString("name"); }
}
