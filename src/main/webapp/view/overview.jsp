<%@ page import="com.ggz.model.Game" %>
<%@ page import="java.util.List" %>
<%@ include file="/view/includes/static/header.jsp" %>
<% if (session.getAttribute("user") == null)
    response.sendRedirect("/login");
   else {
%>
<div class="jumbotron">
  <h2>Overview - Order Detail</h2>
  <ul class="list-group">
    <% for (Game g : (List<Game>) request.getAttribute("games"))
    {
      Game game = g;
    %>
    <li class="list-group-item">
      <span class="badge"><%= game.getPrice() %></span>
      <small><%= game.getName() %> (<%= game.getRating() %><span class="glyphicon glyphicon-star"></span>)</small>
    </li>
    <% } %>

  </ul>
  <ul class="list-group">
    <li class="list-group-item">
      <span class="badge">${sh}$</span>
      Shipping & handling:
    </li>
    <li class="list-group-item">
      <span class="badge">${gst}$</span>
      GST (5%):
    </li>
    <li class="list-group-item">
      <span class="badge">${qst}$</span>
      QST (9.975%):
    </li>
    <li class="list-group-item">
      <span class="badge"><strong>${total}$</strong></span>
      <strong>Total:</strong>
    </li>
  </ul>
  <p>
  <form action="/checkout.do" method="get">
    <input type="hidden" name="status" value="true">
    <button type="submit" class="btn btn-primary btn-lg" >Buy!</button>
</form>
  </p>
</div>
<%@ include file="/view/includes/static/footer.jsp" %>
<% } %>