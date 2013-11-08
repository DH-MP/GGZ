package com.ggz.controller;

import com.ggz.model.activejdbc.Game;
import com.ggz.model.activejdbc.Image;
import org.javalite.activejdbc.Base;
import org.testng.annotations.Test;

import java.util.List;

public class ActiveJDBCTest
{
  @Test
  public void searchTest()
  {
    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");

    List<Game> list = Game.findAll();
    for (Game g : list)
      System.out.println(g.get("name"));

    Base.close();
  }
}
