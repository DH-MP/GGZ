package com.ggz.controller;

import com.ggz.model.Game;
import com.ggz.model.User;
import com.sunnyd.database.Manager;

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
 * Date: 11/25/13
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        System.out.println("gets here");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", request.getParameter("name"));

        String delimiter = "\\s";
        String[] n = name.split(delimiter);
        map.put("n", n);
        String redirect = "/error";
        try {
            //ArrayList<Map<String, Object>> matches = new Game().findAll();
            List<Game> matches = new Game().findAll(map);
            if (matches.size() >= 1){ // means found exactly 1 user with that username and password

                //List<Console> recentConsoles = Game.findAll().limit(9).orderBy("release_date desc");
                request.setAttribute("matches", matches);
                //req.setAttribute("recentConsoles", recentConsoles);
                request.getRequestDispatcher("/view/browse.jsp").forward(request, response);
                //request.setAttribute("user", peer);
                //redirect = "/front.do";
                System.out.println(matches);

            }

            //response.sendRedirect(redirect);

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

