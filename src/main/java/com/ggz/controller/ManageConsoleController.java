package com.ggz.controller;

import com.ggz.model.Console;
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
public class ManageConsoleController  extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer consoleId =  req.getParameter("id") == null ? null : Integer.parseInt(req.getParameter("id").toString());
        Console console = null;
        System.out.println(consoleId);
        if(consoleId != null){
            console = new Console().find(consoleId);
        }
        req.setAttribute("console", console);
        req.getRequestDispatcher("/view/manageConsole.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        for(Field field : Console.class.getDeclaredFields()){
            System.out.println(field.getName());
        }

        Map<String, String[]> map = new HashMap(req.getParameterMap());
        Integer id = Integer.parseInt(map.remove("id")[0]);
        Console c = id == null | id == 0 ? (Console) new Console(): (Console) new Console().find(id);
        Class<?> consoleClassObject = c.getClass();

        for(String entry: map.keySet()){
            try {
                Field attr = consoleClassObject.getDeclaredField(entry.trim().toString());
                Class<?> attrType = attr.getType();
                Method setterMethod = consoleClassObject.getDeclaredMethod("set" + StringUtils.capitalize(entry), attrType);

                String notParsed = map.get(entry)[0].toString();
                switch(attrType.getSimpleName().trim().toLowerCase()){
                    case "double":
                        if(notParsed == null | notParsed.isEmpty()){
                            Double a = 0.00;
                            setterMethod.invoke(c, a);
                        }else{
                            setterMethod.invoke(c, Double.parseDouble(map.get(entry)[0].toString()));
                        }

                        break;
                    case "integer":
                        if(notParsed == null | notParsed.isEmpty()){
                            Integer a = null;
                            setterMethod.invoke(c, a);
                        }else{
                            setterMethod.invoke(c, Integer.parseInt(map.get(entry)[0].toString()));
                        }
                        break;
                    default:
                        setterMethod.invoke(c, map.get(entry)[0]);

                }

            } catch (NoSuchFieldException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                resp.sendRedirect("/MI.do");
                return;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                resp.sendRedirect("/MI.do");
                return;
            } catch (InvocationTargetException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                resp.sendRedirect("/MI.do");
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                resp.sendRedirect("/MI.do");
                return;
            }
        }

        if(id != 0 ){
            c.update();
            req.setAttribute("id", c.getId());
        }else{
            if(c.save()){
                req.setAttribute("id", c.getId());
            }
        }

        resp.sendRedirect("/MI.do");
    }
}
