<%@ include file="/view/includes/static/header.jsp" %>
dsfadsgfsdafsdafds


dfsa
<div class="jumbotron">
  <h2>Overview - Order Details for ${name}</h2>


  <ul class="list-group">
    <% for(int i = 0; i < 2; i+=1) { %>
      <li class="list-group-item">
        <span class="badge">14</span>
        <small>Grand Theft Auto 6 - Quantity: 2</small>
      </li>
    <% } %>
  </ul>
  <ul class="list-group">
    <li class="list-group-item">
      <%--<span class="badge">${name}</span>--%>
      Shipping & handling:
    </li>
    <li class="list-group-item">
      <%--<span class="badge">${name}</span>--%>
      GST (5%):
    </li>
    <li class="list-group-item">
      <%--<span class="badge">${name}</span>--%>
      QST (9.975%):
    </li>
    <li class="list-group-item">
      <%--<span class="badge"><strong><%=request.getAttribute("name")%></strong></span>--%>
      <strong>Total:</strong>
    </li>
  </ul>


  <p><a class="btn btn-primary btn-lg" role="button">Learn more</a></p>
</div>


<%@ include file="/view/includes/static/footer.jsp" %>