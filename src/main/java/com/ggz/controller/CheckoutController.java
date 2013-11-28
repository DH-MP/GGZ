package com.ggz.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
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

//    Double p = shoppingCart.getTotalPrice();

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(2);

    Double net = 0.0;
    for (Game game : games) {
      net =+ game.getPrice();
    }
    Double gst = net * .05;
    Double qst = net * .0975;
    Double tp =  5 + net + gst + qst;

    shoppingCart.setTotalPrice(tp);
    shoppingCart.update();

    request.setAttribute("games", games);
    request.setAttribute("sh", df.format(5));
    request.setAttribute("qst", df.format(qst));
    request.setAttribute("gst", df.format(gst));
    request.setAttribute("total", df.format(tp));
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

//      List<Game> games = new ArrayList<>();
//      ShoppingCart shoppingCart = user.getShoppingCart();
//      shoppingCart.setGames(games);
//      shoppingCart.setTotalPrice(0.0);
//      shoppingCart.setQuantity(0);
//      shoppingCart.setUser(user);
//      shoppingCart.update();

      response.sendRedirect("/success");
    }
    else response.sendRedirect("/error");

  }
}
