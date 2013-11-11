package com.ggz.controller;
import com.ggz.model.Child;
import com.ggz.model.GrandChild;
import com.ggz.model.Person;
import com.sunnyd.database.Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/6/13
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */

public class ClassTableInheritance extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("firstName", request.getParameter("firstName"));
        map.put("lastName", request.getParameter("lastName"));
        map.put("email", request.getParameter("email"));

        switch (request.getParameter("type")){
            case "person":
                new Person(map).save();
                System.out.println("person");
                break;
            case "child":
                map.put("childName", request.getParameter("childName"));
                new Child(map).save();
                System.out.println("child");
                break;
            case "grandChild":
                map.put("childName", request.getParameter("grandChildName"));
                map.put("grandChildName", request.getParameter("grandChildName"));
                new GrandChild(map).save();
                System.out.println("grandchild");
                break;
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Map<String,Object>> persons = Manager.findAll("persons", null);
        ArrayList<Map<String,Object>> childs = Manager.findAll("childs", null);
        ArrayList<Map<String,Object>> grandChilds = Manager.findAll("grand_childs", null);

        request.setAttribute("persons", persons);
        request.setAttribute("childs", childs);
        request.setAttribute("grandChilds", grandChilds);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/view/ClassTableInheritance.jsp");
        dispatcher.forward(request, response);

    }

}
