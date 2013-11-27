package com.ggz.controller;

import com.ggz.model.Game;
import com.ggz.model.ShoppingCart;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/26/13
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManageGameController  extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer gameId = null;
        if(req.getAttribute("id") == null){
            //Get
            gameId = req.getParameter("id") == null ? null : Integer.parseInt(req.getParameter("id"));
        }else{
            //Post Redirect
            gameId =  req.getAttribute("id") == 0 ? null : Integer.parseInt(req.getAttribute("id").toString());
        }

        Game game = null;
        System.out.println(gameId);
        if(gameId != null){
            game = new Game().find(gameId);
        }
        req.setAttribute("game", game);
        req.getRequestDispatcher("/view/manageGame.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Map<String, String[]> map = new HashMap(req.getParameterMap());
        Integer id = Integer.parseInt(map.remove("id")[0]);
        Game g = id == null | id == 0 ? (Game) new Game(): (Game) new Game().find(id);
        Class<?> gameClassObject = g.getClass();

        for(String entry: map.keySet()){
            try {
                Field attr = gameClassObject.getDeclaredField(entry.trim().toString());
                Class<?> attrType = attr.getType();
                Method setterMethod = gameClassObject.getDeclaredMethod("set" + StringUtils.capitalize(entry), attrType);

                String notParsed = map.get(entry)[0].toString();
                switch(attrType.getSimpleName().trim().toLowerCase()){
                    case "double":
                        if(notParsed == null | notParsed.isEmpty()){
                            Double a = 0.00;
                            setterMethod.invoke(g, a);
                        }else{
                            setterMethod.invoke(g, Double.parseDouble(map.get(entry)[0].toString()));
                        }

                        break;
                    case "integer":
                        if(notParsed == null | notParsed.isEmpty()){
                            Integer a = null;
                            setterMethod.invoke(g, a);
                        }else{
                            setterMethod.invoke(g, Integer.parseInt(map.get(entry)[0].toString()));
                        }
                        break;
                    default:
                        setterMethod.invoke(g, map.get(entry)[0]);

                }

            } catch (NoSuchFieldException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (NoSuchMethodException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (InvocationTargetException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        if(id != 0 ){
            g.update();
            req.setAttribute("id", g.getId());
        }else{
            if(g.save()){
                req.setAttribute("id", g.getId());
            }
        }

        doGet(req, resp);
    }
}
