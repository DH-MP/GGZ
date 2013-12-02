package com.ggz.controller;

import com.ggz.model.Order;
import com.ggz.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 12/1/13
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer orderId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("name");
        Order u = new Order().find(orderId);

        u.setStatus("cancelled");
        u.update();

        response.sendRedirect("/front.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // forward to registration jsp
//        ServletContext context = getServletContext();
//        RequestDispatcher dispatcher = context.getRequestDispatcher("/view/register.jsp");
//        dispatcher.forward(request, response);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Map<String, Object> map =  new HashMap<String, Object>();
        map.put("userId", user.getId());
        List<Order> matches = new Order().findAll(map);
        if (matches.size()>1){
        request.setAttribute("matches", matches);
        request.getRequestDispatcher("/view/userOrder.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/front.do");
        }
    }
}