<%@ page import="com.ggz.model.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ggz.model.Console" %>
<%@ page import="com.ggz.model.Order" %>
<%@ include file="/view/includes/static/header.jsp" %>
<a href="/MI.do" class="btn btn-default btn-lg" role="button"><--Inventory</a>

<% Object[] orders = null; %>

<h3>creation</h3>
<div class="OrderInventoryTableContainer">
    <form method="post" action="/MO.do">
        <table  class="table table-bordered table-condensed">
            <% orders =  (Object[])request.getAttribute("creationOrders");
                for(Object o : orders){
                    Order order = (Order) o;
                    String links = "";
                    for(Object g: order.getShoppingCart().getGames().toArray()){
                        Game game = (Game)g;
                        links = "<a href=\"/MG.do?id="+game.getId()+"\" class=\"btn btn-alert\" role=\"button\">"+game.getName()+"</a>, " +links ;
                    }
                    out.println("<tr>");
            %>
            <td>
                <select class="" name="status">
                    <option value=<%=order.getId().toString()+":creation"%> <%= order.getStatus().contentEquals("creation") ? "selected=\"selected\"" : "" %>>creation</option>
                    <option value=<%=order.getId().toString()+":processing"%> <%= order.getStatus().contentEquals("processing") ? "selected=\"selected\"" : "" %>>processing</option>
                    <option value=<%=order.getId().toString()+":shipped"%> <%= order.getStatus().contentEquals("shipped") ? "selected=\"selected\"" : "" %>>shipped</option>
                    <option value=<%=order.getId().toString()+":cancelled"%> <%= order.getStatus().contentEquals("cancelled") ? "selected=\"selected\"" : ""%>>canceled</option>
                </select>
            </td>
            <%
                    out.println("<td>"+order.getOrderDate().toString()+"</td>");
                    out.println("<td>"+order.getUser().getFirstName()+", "+order.getUser().getLastName()+"</td>");
                    out.println("<td>"+links+"</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <button class="btn-success" type="submit">Update</button>
    </form>
</div>


<h3>Processing</h3>
<div class="OrderInventoryTableContainer">
    <form method="post" action="/MO.do">
        <table  class="table table-bordered table-condensed">
            <% orders =  (Object[])request.getAttribute("processingOrders");
                for(Object o : orders){
                    Order order = (Order) o;
                    String links = "";
                    for(Object g: order.getShoppingCart().getGames().toArray()){
                        Game game = (Game)g;
                        links = "<a href=\"/MG.do?id="+game.getId()+"\" class=\"btn btn-alert\" role=\"button\">"+game.getName()+"</a>, " +links ;
                    }
                    out.println("<tr>");
            %>
            <td>
                <select class="" name="status">
                    <option value=<%=order.getId().toString()+":creation"%> <%= order.getStatus().contentEquals("creation") ? "selected=\"selected\"" : "" %>>creation</option>
                    <option value=<%=order.getId().toString()+":processing"%> <%= order.getStatus().contentEquals("processing") ? "selected=\"selected\"" : "" %>>processing</option>
                    <option value=<%=order.getId().toString()+":shipped"%> <%= order.getStatus().contentEquals("shipped") ? "selected=\"selected\"" : "" %>>shipped</option>
                    <option value=<%=order.getId().toString()+":cancelled"%> <%= order.getStatus().contentEquals("cancelled") ? "selected=\"selected\"" : ""%>>canceled</option>
                </select>
            </td>
            <%


                    out.println("<td>"+order.getOrderDate().toString()+"</td>");
                    out.println("<td>"+order.getUser().getFirstName()+", "+order.getUser().getLastName()+"</td>");
                    out.println("<td>"+links+"</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <button class="btn-success" type="submit">Update</button>
    </form>
</div>




<h3>shipped</h3>
<div class="OrderInventoryTableContainer">
    <form method="post" action="/MO.do">
        <table  class="table table-bordered table-condensed">
            <% orders =  (Object[])request.getAttribute("shippedOrders");
                for(Object o : orders){
                    Order order = (Order) o;
                    String links = "";
                    for(Object g: order.getShoppingCart().getGames().toArray()){
                        Game game = (Game)g;
                        links = "<a href=\"/MG.do?id="+game.getId()+"\" class=\"btn btn-alert\" role=\"button\">"+game.getName()+"</a>, " +links ;
                    }
                    out.println("<tr>");
            %>
            <td>
                <select class="" name="status">
                    <option value=<%=order.getId().toString()+":creation"%> <%= order.getStatus().contentEquals("creation") ? "selected=\"selected\"" : "" %>>creation</option>
                    <option value=<%=order.getId().toString()+":processing"%> <%= order.getStatus().contentEquals("processing") ? "selected=\"selected\"" : "" %>>processing</option>
                    <option value=<%=order.getId().toString()+":shipped"%> <%= order.getStatus().contentEquals("shipped") ? "selected=\"selected\"" : "" %>>shipped</option>
                    <option value=<%=order.getId().toString()+":cancelled"%> <%= order.getStatus().contentEquals("cancelled") ? "selected=\"selected\"" : ""%>>canceled</option>
                </select>
            </td>
            <%


                    out.println("<td>"+order.getOrderDate().toString()+"</td>");
                    out.println("<td>"+order.getUser().getFirstName()+", "+order.getUser().getLastName()+"</td>");
                    out.println("<td>"+links+"</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <button class="btn-success" type="submit">Update</button>
    </form>
</div>



<h3>canceled</h3>
<div class="OrderInventoryTableContainer">
    <form method="post" action="/MO.do">
        <table  class="table table-bordered table-condensed">
            <% orders =  (Object[])request.getAttribute("cancelledOrders");
                for(Object o : orders){
                    Order order = (Order) o;
                    String links = "";
                    for(Object g: order.getShoppingCart().getGames().toArray()){
                        Game game = (Game)g;
                        links = "<a href=\"/MG.do?id="+game.getId()+"\" class=\"btn btn-alert\" role=\"button\">"+game.getName()+"</a>, " +links ;
                    }
                    out.println("<tr>");
            %>
            <td>
                <select class="" name="status">
                    <option value=<%=order.getId().toString()+":creation"%> <%= order.getStatus().contentEquals("creation") ? "selected=\"selected\"" : "" %>>creation</option>
                    <option value=<%=order.getId().toString()+":processing"%> <%= order.getStatus().contentEquals("processing") ? "selected=\"selected\"" : "" %>>processing</option>
                    <option value=<%=order.getId().toString()+":shipped"%> <%= order.getStatus().contentEquals("shipped") ? "selected=\"selected\"" : "" %>>shipped</option>
                    <option value=<%=order.getId().toString()+":cancelled"%> <%= order.getStatus().contentEquals("cancelled") ? "selected=\"selected\"" : ""%>>canceled</option>
                </select>
            </td>
            <%


                    out.println("<td>"+order.getOrderDate().toString()+"</td>");
                    out.println("<td>"+order.getUser().getFirstName()+", "+order.getUser().getLastName()+"</td>");
                    out.println("<td>"+links+"</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <button class="btn-success" type="submit">Update</button>
    </form>
</div>



<%@ include file="/view/includes/static/footer.jsp" %>