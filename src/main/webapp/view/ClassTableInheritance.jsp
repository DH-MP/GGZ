<%@ page import="com.ggz.model.Person" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ include file="/view/includes/static/header.jsp" %>




<div class="container">
    <h3>Persons  table</h3>
    <table class="table">
        <%
            ArrayList<Map<String,Object>> persons = (ArrayList<Map<String,Object>>) request.getAttribute("persons");
            Iterator pIter = persons.iterator();
            if(pIter.hasNext()){
                Map<String,Object> personValue = (Map<String,Object>) pIter.next();
                Set<String> keys =  personValue.keySet();
                out.println("<tr>");
                for(String key: personValue.keySet()){
                    out.print("<td>"+key+"</td>");
                }
                out.println("</tr>");
            }
            while(pIter.hasNext()){
                Map<String,Object> personValue = (Map<String,Object>) pIter.next();
                Set<String> keys =  personValue.keySet();
                out.println("<tr>");
                for(String key: personValue.keySet()){
                    out.print("<td>"+personValue.get(key)+"</td>");
                }
                out.println("</tr>");
            }
        %>
    </table>

    <h3>Child table</h3>
    <table class="table">
        <%
            ArrayList<Map<String,Object>> childs = (ArrayList<Map<String,Object>>) request.getAttribute("childs");
            Iterator cIter = childs.iterator();
            if(cIter.hasNext()){
                Map<String,Object> childValue = (Map<String,Object>) cIter.next();
                Set<String> keys =  childValue.keySet();
                out.println("<tr>");
                for(String key: childValue.keySet()){
                    out.print("<td>"+key+"</td>");
                }
                out.println("</tr>");
            }
            while(cIter.hasNext()){
                Map<String,Object> childValue = (Map<String,Object>) cIter.next();
                Set<String> keys =  childValue.keySet();
                out.println("<tr>");
                for(String key: childValue.keySet()){
                    out.print("<td>"+childValue.get(key)+"</td>");
                }
                out.println("</tr>");
            }
        %>
    </table>

    <h3>Grand Child Table</h3>
    <table class="table">
        <%
            ArrayList<Map<String,Object>> grandChilds = (ArrayList<Map<String,Object>>) request.getAttribute("grandChilds");
            Iterator gIter = grandChilds.iterator();
            if(gIter.hasNext()){
                Map<String,Object> grandChildValue = (Map<String,Object>) gIter.next();
                Set<String> keys =  grandChildValue.keySet();
                out.println("<tr>");
                for(String key: grandChildValue.keySet()){
                    out.print("<td>"+key+"</td>");
                }
                out.println("</tr>");
            }
            while(gIter.hasNext()){
                Map<String,Object> grandChildValue = (Map<String,Object>) gIter.next();
                Set<String> keys =  grandChildValue.keySet();
                out.println("<tr>");
                for(String key: grandChildValue.keySet()){
                    out.print("<td>"+grandChildValue.get(key)+"</td>");
                }
                out.println("</tr>");
            }
        %>
    </table>




</div>



<%@ include file="/view/includes/static/footer.jsp" %>
