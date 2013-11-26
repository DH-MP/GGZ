<%--
  Created by IntelliJ IDEA.
  User: Wais
  Date: 11/25/13
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.ggz.model.Game" %>
<%@ page import="com.ggz.model.Image" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ include file="/view/includes/static/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-7">
            <div class="row">
                <% for (Game g : (List<Game>) request.getAttribute("matches"))
                {
                    Game game = g;
                %>
                <div class="col-6 col-sm-6 col-lg-4 flippable" data-id="<%= game.getId() %>">
                    <h2><%= game.getName() %></h2>
                    <div class="box-art-container">
                        <img src="<%= game.getImage().getMediumUrl() %>" class="img-rounded box-art"/>
                    </div>
                    <div>
                        <span class="label label-primary">PC</span>
                        <span class="label label-warning">PlayStation</span>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</div>




<%@ include file="/view/includes/static/footer.jsp" %>