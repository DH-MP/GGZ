package com.ggz.controller;

import com.ggz.model.Game;
import com.ggz.model.Inventory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
* Created with IntelliJ IDEA.
* User: Mike
* Date: 11/21/13
* Time: 11:20 PM
* To change this template use File | Settings | File Templates.
*/
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
          Game game = new Game().find(Integer.valueOf(id));
          if (game != null)
          {
            StringBuilder sb = new StringBuilder();

            sb.append("{");
            sb.append("  \"id\": \"" + game.getId() + "\",");
            sb.append("  \"api_id\": \"" + game.getApiId() + "\",");
            sb.append("  \"price\": \"" + game.getPrice() + "\",");
            sb.append("  \"rating\": \"" + game.getRating() + "\",");
            sb.append("  \"release_date\": \"" + game.getReleaseDate() + "\",");
            sb.append("  \"deck\": \"" + game.getDeck() + "\",");
            sb.append("  \"description\": \"" + game.getDescription() + "\",");
            sb.append("  \"api_detail_url\": \"" + game.getApiDetailUrl() + "\",");
            sb.append("  \"image_url\": \"" + game.getImage().getLargeUrl() + "\",");
            sb.append("}");

            resp.setContentType("application/json");
            resp.setStatus(200);
resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(sb.toString());
          }
          else
          {
            resp.setContentType("application/json");
            resp.setStatus(404);
            resp.setCharacterEncoding("UTF-8");
          }
        }
      }
        String id = req.getParameter("id");
        if(id !=null){
            //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
           //req.setAttribute("game", game);
            req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
           // Base.close();
        }else{
            resp.sendRedirect("/front.do");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //update create etc
    }

}
