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
import java.util.*;

public class FrontController extends HttpServlet
{
  public static int NUMBER_OF_RESULT_SHOWN = 9; // Adjustable
  public static int NUMBER_OF_TOP_GAME_SHOWN = 5; // Adjustable

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    String platform = req.getParameter("platform");
    HttpSession session = req.getSession();
    User user  = (User) session.getAttribute("user");

    ShoppingCart cart = null;
    if (user != null){
      user = new User().find(user.getId()); //Because session store old shopping cart object. force lazy loading pattern to retrieve the object.
      cart = user.getShoppingCart();
      session.setAttribute("cart", cart);
      System.out.println("From Login: "+cart);
    }
    else{
      cart = new ShoppingCart().find(1);//no user associated shopping cart
      session.setAttribute("cart",cart);
      System.out.println("From Non-Login: "+cart);
    }
//    Map<String, Object> map =  new HashMap<String, Object>();
//    map.put("cartId", cart.getId());
//    List<Game> games = new Game().findAll(map);

    System.out.println("adadss");
    List<Game> games = cart.getGames();
    System.out.println("cartIDDD"+cart.getId());
    System.out.println("game :"+games);
    req.setAttribute("g", games);
    System.out.print(cart);

    Random rand = new Random();
    List<Game> allGames = new Game().findAll(null);
    List<Game> recentAddedGames = new ArrayList<Game>();
    List<Game> topGamesOfTheWeek = new ArrayList<Game>();

    for (int i = 0; i < NUMBER_OF_RESULT_SHOWN; i++)
      recentAddedGames.add(allGames.get(rand.nextInt(allGames.size())));
    for (int i = 0; i < NUMBER_OF_TOP_GAME_SHOWN; i++)
      topGamesOfTheWeek.add(allGames.get(rand.nextInt(allGames.size())));

    req.setAttribute("recentAddedGames", recentAddedGames);
    req.setAttribute("topGamesOfTheWeek", topGamesOfTheWeek);
    req.getRequestDispatcher("/view/front.jsp").forward(req, resp);
  }
}
