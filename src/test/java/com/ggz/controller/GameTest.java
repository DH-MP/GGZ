package com.ggz.controller;

import com.ggz.model.activejdbc.*;
import org.javalite.activejdbc.Base;
import org.testng.annotations.Test;

public class GameTest
{
  @Test
  public void createGameTest() throws ClassNotFoundException
  {
    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
    Game g = new Game(Game.findById(1));
    for (Platform p : g.getPlatforms())
      System.out.println(p.get("name"));

    Base.close();
  }

  @Test(dependsOnMethods = {"createGameTest"})
  public void genericManyToManyTest()
  {
    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");

    Game g = new Game(Game.findById(1));
    for (PgRating r : g.getPgRating())
      System.out.println(r.getName());

    Base.close();
  }
}
