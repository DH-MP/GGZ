<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.sunnyd.models.Peer" %>
<%@ include file="/view/includes/static/header.jsp" %>




<div class="container">
    <%
        Peer peer = (Peer) request.getAttribute("Peer");
        out.println("<h3>This is the initial state of Person Instance(Pay attention to document FIELD):</h3>");
        out.println(peer.getClass().getSimpleName());
        Map<String, Object> a = peer.toMap();
        for(String key: a.keySet()){
            out.println("<b>"+key+"</b>: "+a.get(key));
            out.println("<br/>");
        }
        peer.getDocuments();
        out.println("<h3>This is the state of Person after calling a getter method on a collection of objects(Pay attention to document FIELD)</h3>");
        a = peer.toMap();
        for(String key: a.keySet()){
            out.println("<b>"+key+"</b>: "+a.get(key));
            out.println("<br/>");
        }
    %>

</div>



<%@ include file="/view/includes/static/footer.jsp" %>
