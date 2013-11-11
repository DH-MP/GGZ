package com.ggz.controller;

import com.sunnyd.database.Manager;
import com.sunnyd.models.Child;
import com.sunnyd.models.GrandChild;
import com.sunnyd.models.Peer;
import com.sunnyd.models.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/10/13
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class LazyInitialization extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("Peer", new Peer().find(1));
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/view/lazyInit.jsp");
        dispatcher.forward(request, response);

    }

}
