package com.ggz.controller;

import com.ggz.model.ShoppingCart;
import com.ggz.model.Game;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
* Created with IntelliJ IDEA.
* User: Quang
* Date: 2013-11-20
* Time: 5:29 PM
* To change this template use File | Settings | File Templates.
*/

public class CartController extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    int game_id = Integer.parseInt(request.getParameter("game_id"));
    int cart_id = Integer.parseInt(request.getParameter("cart_id"));
    Game game = new Game().find(game_id);
    ShoppingCart cart = new ShoppingCart().find(cart_id);

    // here we should validate the input...

    // check if user already exists
    Map<String, Object> map = new HashMap<String, Object>();
//    map.put("totalPrice", total_price);
//    map.put("quantity", quantity);
//    map.put("userId", user_id);
//      try {
//        ShoppingCart cart = new ShoppingCart().find(id);
//        cart.setTotalPrice(total_price);
//        cart.setQuantity(quantity);
//
//        redirect = "/front.do";
        cart.update();

//            Peer peer = new Peer(Manager.find(id, "peers"));
//        HttpSession session = request.getSession();
//        session.setAttribute("user", peer);
//        response.sendRedirect(redirect);

//      } catch (Exception e) {
//        e.printStackTrace();
//      }



  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {

  }
}
