package com.ggz.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* Created with IntelliJ IDEA.
* User: bobbyyit
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

    int id = Integer.parseInt(request.getParameter("id"));

    String total_price = request.getParameter("total_price");
    String quantity = request.getParameter("quantity");
    String user_id = request.getParameter("user_id");

    // here we should validate the input...

    // check if user already exists
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("totalPrice", total_price);
    map.put("quantity", quantity);
    map.put("userId", user_id);
      try {
        Cart cart = new Cart().find(id);
        cart.setTotalPrice(total_price);
        cart.setQuantity(quantity);

        redirect = "/front.do";
        cart.update();

//            Peer peer = new Peer(Manager.find(id, "peers"));
        HttpSession session = request.getSession();
        session.setAttribute("user", peer);
        response.sendRedirect(redirect);

      } catch (Exception e) {
        e.printStackTrace();
      }



  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {

  }
}
