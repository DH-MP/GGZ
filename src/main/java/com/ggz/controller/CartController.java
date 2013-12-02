package com.ggz.controller;

import com.ggz.model.ShoppingCart;
import com.ggz.model.Game;
import com.ggz.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

    int game_id = Integer.parseInt(request.getParameter("game_id"));
    int cart_id = Integer.parseInt(request.getParameter("cart_id"));

    System.out.println(cart_id);


    System.out.println("dfdf"+game_id);
    System.out.println("aaaaaaaaa"+cart_id);
    ShoppingCart cart = new ShoppingCart().find(cart_id);
    if(cart_id ==1){
      HttpSession session = request.getSession();
      session.setAttribute("cart", cart);
      request.getRequestDispatcher("/view/register.jsp").forward(request, response);
    }else
    {
        List<Game> games = cart.getGames();
        Game newGame = new Game().find(game_id);
        games.add(newGame);
    //    Map<String, Object> map =  new HashMap<String, Object>();
    //    map.put("id", game_id);
        Double total_price=0.0;
        int quantity = 0;
        //Game game = new Game().find(game_id);
    //    List<Game> games = new Game().findAll(map);



    //    games.add(newgame);
        cart.setGames(games);
        for (Object gameObject : games)
        {
          Game a = (Game) gameObject;

         total_price += a.getPrice();
         quantity++;

        }
        System.out.println(total_price);
        cart.setTotalPrice(total_price);
        cart.setQuantity(quantity);
        System.out.println(cart.getGames());
        // here we should validate the input...


            cart.update();

    //    request.setAttribute("games", games);
    //    request.setAttribute("cart", cart);

        response.sendRedirect("/front.do");
    //    request.getRequestDispatcher("/view/front.jsp").forward(request, response);

    //            Peer peer = new Peer(Manager.find(id, "peers"));
    //        HttpSession session = request.getSession();
    //        session.setAttribute("user", peer);
    //        response.sendRedirect(redirect);

    //      } catch (Exception e) {
    //        e.printStackTrace();
    //      }


    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {

  }
}
