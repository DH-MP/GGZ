package com.ggz.controller;

import com.ggz.model.Console;
import com.ggz.model.Game;
import com.ggz.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 12/1/13
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManageOrderController extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        //Instantiate Object
        List<Order> orderObjects = new Order().findAll(null);
        Map<String, List<Order>> collections = new HashMap<String, List<Order>>();
        collections.put("creation", new ArrayList<Order>());
        collections.put("shipped", new ArrayList<Order>());
        collections.put("processing", new ArrayList<Order>());
        collections.put("cancelled", new ArrayList<Order>());
        for(Order order: orderObjects){
                List<Order> l = collections.get(order.getStatus());
                l.add(order);
                collections.put(order.getStatus(), l);
        }



        req.setAttribute("cancelledOrders", collections.get("cancelled").toArray());
        req.setAttribute("creationOrders", collections.get("creation").toArray());
        req.setAttribute("shippedOrders", collections.get("shipped").toArray());
        req.setAttribute("processingOrders", collections.get("processing").toArray());
        req.getRequestDispatcher("/view/manageOrder.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String status = req.getParameter("status");
        String[] split = status.split(":");
        Integer id = Integer.parseInt(split[0]);
        String statusValue = split[1];

        Order o = new Order().find(id);
        o.setStatus(statusValue);

        System.out.println(status);
        resp.sendRedirect("/MO.do"); // redirect to homepage
    }


}
