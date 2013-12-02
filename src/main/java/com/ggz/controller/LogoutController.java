package com.ggz.controller;

import com.ggz.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 12/1/13
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // invalidate the current session
        response.sendRedirect("/"); // redirect to homepage
        System.out.println(session.getAttribute("user"));
    }
}