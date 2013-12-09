package com.ggz.controller;

import com.ggz.model.Game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchController extends HttpServlet
{
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException
  {
    String name = request.getParameter("name");
    Map<String, Object> condition = new HashMap<String, Object>();
    condition.put("name", name);

    List<Game> games = new Game().findAll(condition);
    request.setAttribute("queryString", name);
    request.setAttribute("matches", games);
    request.getRequestDispatcher("/view/browse.jsp")
        .forward(request, response);
  }
}

