<%@ page import="com.ggz.model.User" %>
<%@ page import="com.ggz.model.Order" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Wais
  Date: 12/1/13
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/view/includes/static/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(document).ready(function(){
        $("#edit").click(function(){
            $(".orderProperties").attr("readonly",false);
        });
        $("#done").click(function(){
            $(".orderProperties").attr("readonly",true);
        });

    });
</script>
<%
    User u = (User) session.getAttribute("user");
    //Map<String, Object> map =  new HashMap<String, Object>();
    //map.put("userId", u.getId());
    //List<Order> matches = new Order().findAll(map);
    //if (matches != null) {
%>
<% for (Order o : (List<Order>) request.getAttribute("matches"))
{
    Order order = o;

    if(order.getStatus().equals("creation")){
%>
<br>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-3">
            <div class="thumbnail">
                <div class="caption">
                    <h4><%= u.getFirstName() %> <%= u.getLastName() %></h4>
                    <form action="/userOrder.do" method="post">

                        <table>
                            <tr><td>id</td><td><input type="text" class="orderId" name="id" value="<%= order.getId().toString() %>" readonly></td></tr>
                            <tr><td>Status</td><td><input type="text" class="orderProperties" name="status" value="<%= order.getStatus().toString() %>" readonly></td></tr>
                            <tr><td>OrderDate</td><td><input type="text" class="orderDate" name="order_date" value="<%= order.getOrderDate().toString() %>" readonly></td></tr>
                        </table>

                        <input type="submit" value="Cancel Order" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%
    }    }
%>



<%@ include file="/view/includes/static/footer.jsp" %>