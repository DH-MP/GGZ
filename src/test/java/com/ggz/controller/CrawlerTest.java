package com.ggz.controller;

import com.ggz.model.activejdbc.Game;
import org.javalite.activejdbc.Base;
import org.testng.annotations.Test;

import java.util.List;

public class CrawlerTest
{
  @Test
  public void searchTest()
  {
    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");

    List<Game> gameList = Crawler.search("mario");
    for (Game game : gameList)
      System.out.println(game);

    Base.close();
  }
}
