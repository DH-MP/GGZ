<%@ page import="com.ggz.model.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ggz.model.Console" %>
<%@ include file="/view/includes/static/header.jsp" %>
<a href="/MG.do" class="btn btn-default btn-lg" role="button">Create Game</a>
<a href="/MC.do" class="btn btn-default btn-lg" role="button">Create Console</a>
<div class="GameInventoryTableContainer">

    <form method="post" action="/MI.do">
        <table  class="table table-bordered table-condensed">
        <% Object[] games =  (Object[])request.getAttribute("allGames");
           for(Object g : games){
               Game game = (Game) g;
               out.println("<tr>");
                   out.println("<td>"+game.getName()+"</td>");
                   out.println("<td>"+game.getRating()+"</td>");
                   out.println("<td>"+game.getDeck()+"</td>");

                   Double price = game.getPrice() == null ? 0 : game.getPrice();
                   out.println("<td><input name='"+game.getId()+":price' value="+ price +"></td>");

                   Integer qt = game.getQuantity() == null ? 0 : game.getQuantity();
                   out.println("<td><input name='"+game.getId()+":quantities' value="+ qt +"></td>");

                   out.println("<td><a href=\"/MG.do?id="+game.getId()+"\" class=\"btn btn-alert\" role=\"button\">Edit Game</a></td>");
                   out.println("<td><a href=\"/MG.do?delete="+game.getId()+"\" class=\"btn btn-alert\" role=\"button\">Delete Game</a></td>");
               out.println("</tr>");
           }
        %>
        <input type="hidden" name="className" value="game">
        </table>
        <button class="btn-success" type="submit">Update</button>
    </form>
</div>


<div class="ConsoleInventoryTableContainer">
    <form method="post" action="/MI.do">
        <table  class="table table-bordered table-condensed">
            <% Object[] consoles =  (Object[])request.getAttribute("allConsoles");
                for(Object c : consoles){
                    Console console = (Console) c;
                    String consoleName = console.getPlatform()== null? "N/A": console.getPlatform().getName();
                    out.println("<tr>");
                    out.println("<td>"+consoleName+"</td>");
                    out.println("<td>"+console.getDescription()+"</td>");

                    Double price = console.getPrice() == null ? 0 : console.getPrice();
                    out.println("<td><input name='"+console.getId()+":price' value="+ price +"></td>");

                    Integer qt = console.getQuantity() == null ? 0 : console.getQuantity();
                    out.println("<td><input name='"+console.getId()+":quantities' value="+ qt +"></td>");

                    out.println("<td><a href=\"/MC.do?id="+console.getId()+"\" class=\"btn btn-alert\" role=\"button\">Edit Game</a></td>");
                    out.println("</tr>");
                }
            %>
            <input type="hidden" name="className" value="console">
        </table>
        <button class="btn-success" type="submit">Update</button>
    </form>
</div>

<%@ include file="/view/includes/static/footer.jsp" %>