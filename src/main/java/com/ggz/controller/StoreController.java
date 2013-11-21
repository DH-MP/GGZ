package com.ggz.controller;

import com.ggz.model.activejdbc.Inventory;
import org.javalite.activejdbc.Base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/20/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoreController  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("in store");
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
        System.out.println(new Inventory().getItems());
    }
}
