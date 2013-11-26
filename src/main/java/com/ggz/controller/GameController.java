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
        int id = Integer.parseInt( (String) req.getParameter( "id" ) );
        if(id != 0){
           // Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
            Game game = new Game().find(id);
            req.setAttribute("game", game);
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
