package com.ggz.model.activejdbc;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("activejdbcimages")
public class ActiveJDBCImage extends Model
{
  String tinyUrl;
  String mediumUrl;
  String largeUrl;

//  public String getTinyUrl()
//  {
//    return tinyUrl;
//  }
//
//  public void setTinyUrl(String tinyUrl)
//  {
//    this.tinyUrl = tinyUrl;
//  }
//
//  public String getMediumUrl()
//  {
//    return mediumUrl;
//  }
//
//  public void setMediumUrl(String mediumUrl)
//  {
//    this.mediumUrl = mediumUrl;
//  }
//
//  public String getLargeUrl()
//  {
//    return largeUrl;
//  }
//
//  public void setLargeUrl(String largeUrl)
//  {
//    this.largeUrl = largeUrl;
//  }
}
