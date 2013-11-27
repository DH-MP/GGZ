<%@ include file="/view/includes/static/header.jsp" %>
<% if (session.getAttribute("user") == null)
  response.sendRedirect("/login");
%>
<div class="jumbotron">
  <h1>Congratulation on your awesome purchase at Game Gravity Zone!</h1>
  <p>
    You will shortly receive a notification of the invoice, along with the tracking number. We hope to see you again!
  </p>
  <p><a class="btn btn-primary btn-lg" role="button" href="/front.do">Return to homepage</a></p>
</div>

<%@ include file="/view/includes/static/footer.jsp" %>