package com.ggz.controller;

import com.ggz.model.activejdbc.Game;
import org.javalite.activejdbc.Base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FrontController extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
    List<Game> recentAddedGames = Game.findAll().limit(9).orderBy("release_date desc");
    req.setAttribute("recentAddedGames", recentAddedGames);
    req.getRequestDispatcher("/view/front.jsp").forward(req, resp);
  }
}
