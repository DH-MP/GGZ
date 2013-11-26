package com.ggz.controller;

import com.ggz.model.Console;
import com.ggz.model.Game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/26/13
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManageInventoryController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        //Instantiate Object
        List<Game> gameObjects = new Game().findAll(null);

        //Instantiate Object
        List<Console> consoleObjects = new Console().findAll(null);
        req.setAttribute("allGames", gameObjects.toArray());
        req.setAttribute("allConsoles", consoleObjects.toArray());
        req.getRequestDispatcher("/view/inventory.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Map<String, String[]> map = req.getParameterMap();
        Map<String, String[]> unlockedMap = new HashMap<String, String[]>();
        unlockedMap.putAll(map);
        String className = unlockedMap.remove("className")[0];

        //Game update
        if(className.contentEquals("game")){
            for(String entry: unlockedMap.keySet()){
                String[] parameter = entry.split(":");
                String attribute = parameter[1];
                Integer id = Integer.parseInt(parameter[0]);
                Game a = new Game().find(id);
                if(attribute.contentEquals("price")){
                    a.setPrice(Double.parseDouble(unlockedMap.get(entry)[0]));
                }
                if(attribute.contentEquals("quantities")){
                    a.setQuantity(Integer.parseInt(unlockedMap.get(entry)[0]));
                }
                a.update();
            }
        }

        //Console update
        if(className.contentEquals("console")){
            for(String entry: unlockedMap.keySet()){
                String[] parameter = entry.split(":");
                String attribute = parameter[1];
                Integer id = Integer.parseInt(parameter[0]);
                Console a = new Console().find(id);
                if(attribute.contentEquals("price")){
                    a.setPrice(Double.parseDouble(unlockedMap.get(entry)[0]));
                }
                if(attribute.contentEquals("quantities")){
                    a.setQuantity(Integer.parseInt(unlockedMap.get(entry)[0]));
                }
                a.update();
            }
        }

        doGet(req, resp);

    }



}

