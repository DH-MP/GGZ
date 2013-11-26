package com.ggz.controller;

import com.ggz.model.User;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            ArrayList<Map<String, Object>> matches = new User().findAll(map);
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
