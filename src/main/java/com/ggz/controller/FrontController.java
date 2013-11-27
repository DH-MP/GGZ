package com.ggz.controller;

import com.ggz.model.Console;
import com.ggz.model.ShoppingCart;
import com.ggz.model.Game;
import com.ggz.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    String platform = req.getParameter("platform");
    HttpSession session = req.getSession();
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
    System.out.print(cart);
    if (cart != null){
      req.setAttribute  ("cart", cart);
      System.out.println("From Login: "+cart);
    }
    else{
      cart = new ShoppingCart().find(1);
      session.setAttribute("cart",cart);
      System.out.println("From Non-Login: "+cart);
    }
//    Map<String, Object> map =  new HashMap<String, Object>();
//    map.put("cartId", cart.getId());
//    List<Game> games = new Game().findAll(map);
    List<Game> games = cart.getGames();
    System.out.println(games);
    req.setAttribute("g", games);
    System.out.print(cart);

    List<Game> recentAddedGames = new Game().findAll(null);
    req.setAttribute("recentAddedGames", recentAddedGames
        .subList(0, Math.min(recentAddedGames.size(), NUMBER_OF_RESULT_SHOWN)));
    req.getRequestDispatcher("/view/front.jsp").forward(req, resp);
  }
}
