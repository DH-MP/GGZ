package com.ggz.controller;

import com.ggz.model.activejdbc.Game;
import com.ggz.model.activejdbc.Inventory;
import org.javalite.activejdbc.Base;

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
        String id = req.getParameter("id");
        if(id !=null){
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
            req.setAttribute("game", Game.findById(id));
            req.getRequestDispatcher("/view/game.jsp").forward(req, resp);
            Base.close();
        }else{
            resp.sendRedirect("/front.do");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //update create etc
    }

}
