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
        List<Game> games = new Game().findAll(null);

        System.out.println("gets here");

        Map<String, Object> map = new HashMap<String, Object>();
        List<Game> matches = new Game().findAll(map);
        matches.removeAll(matches);
        System.out.println("cccccc"+matches);
        Object[] gamesArray = games.toArray();
        for (Object gameObject : games)
        {

            Game a = (Game) gameObject;

            if( a.getName().contains(name))
            {
                System.out.println(name);
                map.put("name", a.getName());
                System.out.println(a.getName());
                System.out.println("bbbbbbbbbb"+map);
                matches.add(a);

           }

            //List<Game> matches = new Game().findAll(map);
        }
        System.out.println("zzzzzzzzz"+matches);
        //List<Game> matches = new Game().findAll(map);
        if (matches.size() >= 1){

            System.out.println("dffdsf"+map);
            request.setAttribute("matches", matches);

            System.out.println(matches);

        }

        request.getRequestDispatcher("/view/browse.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // forward to registration jsp
//        ServletContext context = getServletContext();
//        RequestDispatcher dispatcher = context.getRequestDispatcher("/view/register.jsp");
//        dispatcher.forward(request, response);

    }


}

