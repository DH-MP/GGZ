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
  int NUMBER_OF_RESULT_SHOWN = 9; // Our preference

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    List<Game> recentAddedGames = (new Game()).findAll(null);

    req.setAttribute("recentAddedGames", recentAddedGames
        .subList(0, Math.min(recentAddedGames.size(), NUMBER_OF_RESULT_SHOWN)));
    req.getRequestDispatcher("/view/front.jsp").forward(req, resp);
  }
}
