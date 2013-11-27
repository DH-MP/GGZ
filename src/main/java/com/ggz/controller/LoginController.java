package com.ggz.controller;

import com.ggz.model.Game;
import com.ggz.model.User;

import javax.servlet.FilterChain;
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
import java.util.List;
import java.util.Map;

public class LoginController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("gets here");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", request.getParameter("username"));
        map.put("password", request.getParameter("password"));

        String redirect = "/error";
        try {
            //ArrayList<Map<String, Object>> matches = new User().findAll(map);
            List<User> matches = new User().findAll(map);

            if (matches.size() == 1){ // means found exactly 1 user with that username and password
                //Map<String, Object> match = matches.get(0);
                // get this hashmap from the arraylist
                User u = matches.get(0);
                // store the peer obj in session
                HttpSession session = request.getSession();
                session.setAttribute("user", u);
                session.setMaxInactiveInterval(259200); // 3 days in secs
                //request.setAttribute("user", peer);
                redirect = "/front.do";

            }

            response.sendRedirect(redirect);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
