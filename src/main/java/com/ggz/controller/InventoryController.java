package com.ggz.controller;

import com.ggz.model.Game;
import com.ggz.model.Inventory;
import com.ggz.model.Item;
//import org.javalite.activejdbc.Base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* User: Mike
* Date: 11/21/13
* Time: 6:53 PM
* To change this template use File | Settings | File Templates.
*/
public class InventoryController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
        //System.out.println(new Inventory().getItems());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }

}
