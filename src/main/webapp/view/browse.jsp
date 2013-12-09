<%@ page import="com.ggz.model.Game" %>
<%@ page import="java.util.List" %>
<%@ include file="/view/includes/static/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a href="/" class="navbar-brand">Gravity Game Zone</a>
    </div>
  </div>
</div>

<div class="container content">
  <div class="page-header">
    <h2>
      Your search for "<%= request.getAttribute("queryString") %>" successfully
      yielded <%= ((List<?>)request.getAttribute("matches")).size() %> results.
    </h2>
  </div>
  <div class="col-xs-12 col-sm-7">
    <div class="row">
      <% for (Game game : (List<Game>) request.getAttribute("matches")) { %>
      <div class="col-6 col-sm-6 col-lg-4 flippable"
           data-id="<%= game.getId() %>">
        <h2><%= game.getName() %>
        </h2>

        <div class="box-art-container">
          <img src="<%= game.getImage().getMediumUrl() %>"
               class="img-rounded box-art"/>
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
<%@ include file="/view/includes/static/footer.jsp" %>
