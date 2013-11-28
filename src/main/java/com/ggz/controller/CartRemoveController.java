package com.ggz.controller;

import javax.servlet.http.HttpServlet;
import com.ggz.model.ShoppingCart;
import com.ggz.model.Game;
import com.ggz.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Zearf
 * Date: 11/27/13
 * Time: 6:10 PM
 * To change this template use File | Settings | File Templates.
 */

public class CartRemoveController extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    System.out.println("It got there");
    int game_id = Integer.parseInt(request.getParameter("game_id"));
    int cart_id = Integer.parseInt(request.getParameter("cart_id"));

    ShoppingCart cart = new ShoppingCart().find(cart_id);
    List<Game> games = cart.getGames();
    Game deleteGame = new Game().find(game_id);
    games.remove(deleteGame);

    Double total_price=0.0;
    cart.setGames(games);
    for (Object gameObject : games)
    {
      Game a = (Game) gameObject;

      total_price += a.getPrice();

    }
    cart.setTotalPrice(total_price);
    cart.update();

    HttpSession session = request.getSession();
    session.setAttribute("cart", cart);

    response.sendRedirect("/front.do");

  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {

  }
}
