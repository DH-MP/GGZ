<%@ page import="com.ggz.model.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ggz.model.Console" %>
<%@ include file="/view/includes/static/header.jsp" %>

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
                   out.println("<td>"+game.getDescription()+"</td>");
                   out.println("<td><input name='"+game.getId()+":price' value="+game.getPrice()+"></td>");
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
                    out.println("<td><input name='"+console.getId()+":price' value="+console.getPrice()+"></td>");
                    out.println("</tr>");
                }
            %>
            <input type="hidden" name="className" value="console">
        </table>
        <button class="btn-success" type="submit">Update</button>
    </form>
</div>

<%@ include file="/view/includes/static/footer.jsp" %>