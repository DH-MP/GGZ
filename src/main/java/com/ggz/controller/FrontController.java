package com.ggz.controller;

import com.ggz.model.Console;
import com.ggz.model.Game;

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
    String platform = req.getParameter("platform");
    List<Game> recentAddedGames = Game.find().limit(9).orderBy("release_date desc");
    List<Console> recentConsoles = Game.findAll().limit(9).orderBy("release_date desc");
    req.setAttribute("recentAddedGames", recentAddedGames);
    req.setAttribute("recentConsoles", recentConsoles);
    req.getRequestDispatcher("/view/front.jsp").forward(req, resp);
  }
}
