package com.ggz.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ggz.model.*;

/**
 * Created with IntelliJ IDEA.
 * User: bobbyyit
 * Date: 2013-11-20
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */

public class CheckoutController extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String postal_code = request.getParameter("postal");
    String province = request.getParameter("province");
    String country = request.getParameter("country");
    String credit_card = request.getParameter("creditcard");
    String credit_card_number = request.getParameter("cardnumber");
    String security_pin_number = request.getParameter("sec");
    String cc_name = request.getParameter("ccname");
    String expiration_date = request.getParameter("expirationdate");

    HttpSession session = request.getSession();
    User user = (User)session.getAttribute("user");

    CreditCard cc = new CreditCard();
    List<CreditCard> creditCardList = new ArrayList<>();
    cc.setCcNumber(Integer.parseInt(credit_card_number));//11 characters max
    creditCardList.add(cc);

    user.setAddress(address);
    user.setCreditCards(creditCardList);
    user.update();

    ShoppingCart shoppingCart = user.getShoppingCart();
    List<Game> games = shoppingCart.getGames();

    Double p = shoppingCart.getTotalPrice();

    Double net = 0.0;
//    for (Game game : games) {
//      net =+ game.getPrice();
//    }                    ;
    Double gst = p * .05;
    Double qst = p * .0975;
    Double tp =  5 + p + gst + qst;

//    shoppingCart.setTotalPrice(tp);
//    shoppingCart.update();

    request.setAttribute("games", games);
    request.setAttribute("sh", "5.00");
    request.setAttribute("qst", qst);
    request.setAttribute("gst", gst);
    request.setAttribute("total", tp);
    request.getRequestDispatcher("/overview").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String status = request.getParameter("status");
    if(status.contentEquals("true"))
    {
      HttpSession session = request.getSession();
      User user = (User)session.getAttribute("user");

      Order order = new Order();
      order.setStatus("creation");
      order.setUser(user);
      order.setShoppingCart(user.getShoppingCart());
      order.save();

      response.sendRedirect("/success");
    }
    else response.sendRedirect("/error");

  }
}
