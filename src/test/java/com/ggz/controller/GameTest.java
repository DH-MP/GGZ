package com.ggz.controller;

import com.ggz.model.activejdbc.*;
import org.javalite.activejdbc.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GameTest
{
  @BeforeClass
  public void setUp()
  {
    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
  }

  @Test
  public void createGameTest() throws ClassNotFoundException
  {
    Game g = Game.findById(1);
    for (Platform p : g.getPlatforms())
      System.out.println(p.getName());
  }

  @Test(dependsOnMethods = {"createGameTest"})
  public void genericManyToManyTest()
  {
    Game g = Game.findById(1);
    for (PgRating r : g.getPgRating())
      System.out.println(r.getName());
  }

  @Test(dependsOnMethods = {"genericManyToManyTest"})
  public void imageUrlTest()
  {
    Game g =Game.findById(1);
    Image img = g.getImage();
    System.out.println(img.getLargeThumb());
    System.out.println(img.getMediumThumb());
    System.out.println(img.getSmallThumb());
  }

  @AfterClass
  public void tearDown()
  {
    Base.close();
  }
}
