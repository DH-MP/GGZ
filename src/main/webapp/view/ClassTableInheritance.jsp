<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ include file="/view/includes/static/header.jsp" %>




<div class="container">
    <form style="float:left; margin-right: 20px;" action="/classTableInheritanceAndForeignKey" method="post">
        <h2>Create Person</h2>
        <input type="text" class="form-control" name="firstName" style="margin:10px 0" placeholder="First Name" autofocus="">
        <input type="text" class="form-control" name="lastName" style="margin:10px 0" placeholder="Last Name">
        <input type="text" class="form-control" name="email" style="margin:10px 0" placeholder="Email">
        <input type="hidden"  name="type" value="person">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Create Person</button>
    </form>
    <div style="float:left; width:200px; margin-top:100px">
        <p><h1><</h1></p><h3> Inherits From</h3>
    </div>
    <form style="float:left; margin-right: 20px;" action="/classTableInheritanceAndForeignKey" method="post">
        <h2>Create Child</h2>
        <input type="text" class="form-control" name="firstName" style="margin:10px 0" placeholder="First Name" autofocus="">
        <input type="text" class="form-control" name="lastName" style="margin:10px 0" placeholder="Last Name">
        <input type="text" class="form-control" name="email" style="margin:10px 0" placeholder="Email">
        <input type="text" class="form-control" name="childName" style="margin:10px 0" placeholder="childName">
        <input type="hidden" name="type" value="child">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Create Child</button>
    </form>
    <div style="float:left; width:200px; margin-top:100px">
        <p><h1><</h1></p><h3> Inherits From</h3>
    </div>
    <form style="float:left; margin-right: 20px;" action="/classTableInheritanceAndForeignKey" method="post">
        <h2>Create GrandChild</h2>
        <input type="text" class="form-control" name="firstName" style="margin:10px 0" placeholder="First Name" autofocus="">
        <input type="text" class="form-control" name="lastName" style="margin:10px 0" placeholder="Last Name">
        <input type="text" class="form-control" name="email" style="margin:10px 0" placeholder="Email">
        <input type="text" class="form-control" name="childName" style="margin:10px 0" placeholder="childName">
        <input type="text" class="form-control" name="grandChildName" style="margin:10px 0" placeholder="grandChildName">
        <input type="hidden"  name="type" value="grandChild">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Create GrandChild</button>
    </form>
    <div style="clear:both"></div>

    <br/>
    <p>
        Note*: The following table is the live view of the database. It is to illustrate the result of implementing
        class table inheritance.
    </p>

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
                out.println("<tr>");
                for(String key: personValue.keySet()){
                    out.print("<td>"+personValue.get(key)+"</td>");
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
                out.println("<tr>");
                for(String key: childValue.keySet()){
                    out.print("<td>"+childValue.get(key)+"</td>");
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
                out.println("<tr>");
                for(String key: grandChildValue.keySet()){
                    out.print("<td>"+grandChildValue.get(key)+"</td>");
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
