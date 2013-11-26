package com.ggz.controller;

/**
* Created with IntelliJ IDEA.
* User: Wais
* Date: 11/20/13
* Time: 8:25 PM
* To change this template use File | Settings | File Templates.
*/


import com.ggz.model.User;
import com.sunnyd.database.Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RegistrationController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");

        //doGet(request, response);
        // get all register input
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String user_name = request.getParameter("user_name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        // here we should validate the input...

        // check if user already exists
        Map<String, Object> map =  new HashMap<String, Object>();
        map.put("userName", user_name);
        String redirect = "/error";
        try {
            ArrayList<Map<String, Object>> matches = Manager.findAll("users", map);
            System.out.println(matches);
            if (matches.size() == 0){ // means user does not exist
                User u = new User();
                u.setFirstName(first_name);
                u.setLastName(last_name);
                u.setUserName(user_name);
                u.setAddress(address);
                u.setPassword(password);
                u.save();

                HttpSession session = request.getSession();
                session.setAttribute("user", u);
                redirect = "/front.do";
            }
            response.sendRedirect(redirect);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // forward to registration jsp
//        ServletContext context = getServletContext();
//        RequestDispatcher dispatcher = context.getRequestDispatcher("/view/register.jsp");
//        dispatcher.forward(request, response);

    }


}
