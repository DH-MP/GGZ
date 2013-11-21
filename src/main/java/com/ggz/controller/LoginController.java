package com.ggz.controller;

import com.ggz.model.activejdbc.User;
import org.javalite.activejdbc.Base;

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

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 11/21/13
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/soen387", "root", "root");
        System.out.println("gets here");
        //Map<String, Object> map = new HashMap<String, Object>();
        //map.put("userName", request.getParameter("username"));
        //map.put("password", request.getParameter("password"));

        String user_name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("fsdfdsfsdf" + password);

        String redirect = "/error";
        try {
            //ArrayList<Map<String, Object>> matches = Manager.findAll("peers", map);
            List<User> matches = User.where("user_name = '" + user_name + "' AND password = '" + password +"'");
            System.out.println(matches);

            if (matches.size() == 1){ // means found exactly 1 user with that username and password
               // Map<String, Object> match = matches.get(0); // get this hashmap from the arraylist
                //Peer peer = new Peer(match);
                User u = new User(matches.get(0));
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
