package com.ggz.controller;

import com.ggz.model.Game;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GameController extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    if (req.getParameter("api") != null
        && req.getParameter("api").equalsIgnoreCase("true"))
    {
      String id = req.getParameter("id");
      if (id != null)
      {
        Game game = new Game().find(Integer.parseInt(id));
        if (game != null)
        {
          StringBuilder sb = new StringBuilder();

          sb.append("{");
          sb.append("  \"id\": \"" + game.getId() + "\",");
          sb.append("  \"title\": \"" + game.getName() + "\",");
          sb.append("  \"api_id\": \"" + game.getApiId() + "\",");
          sb.append("  \"price\": \"" + game.getPrice() + "\",");
          sb.append("  \"rating\": \"" + game.getRating() + "\",");
          sb.append("  \"release_date\": \"" + game.getReleaseDate() + "\",");
          sb.append("  \"deck\": \"" + StringEscapeUtils.escapeHtml4(game.getDeck()) + "\",");
          sb.append("  \"api_detail_url\": \"" + game.getApiDetailUrl() + "\",");
          sb.append("  \"image_url\": \"" + game.getImage().getLargeUrl() + "\"");
          sb.append("}");

          resp.setContentType("application/json");
          resp.setStatus(200);
          resp.setCharacterEncoding("UTF-8");
          resp.getWriter().println(sb.toString());
        }
        else
        {
          resp.setContentType("application/json");
          resp.setStatus(404);
          resp.setCharacterEncoding("UTF-8");
        }
      }
    }
    else
    {
      resp.sendRedirect("/front.do");
    }
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    //update create etc
  }

}
