package com.ggz.controller;

import com.ggz.model.Console;
import com.ggz.model.Game;
import com.ggz.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrontController extends HttpServlet
{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String platform = req.getParameter("platform");

    //Map<String, Object> map = new HashMap<String, Object>();
   // map.put("releaseDate", req.getParameter("release_date"));


    //List<Game> recentAddedGames = new Game().find(1);git
    List<Game> recentAddedGames = new Game().findAll(null);

      //List<Console> recentConsoles = Game.findAll().limit(9).orderBy("release_date desc");
    req.setAttribute("recentAddedGames", recentAddedGames);
    //req.setAttribute("recentConsoles", recentConsoles);
    req.getRequestDispatcher("/view/front.jsp").forward(req, resp);
  }
}
