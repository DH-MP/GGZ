<%@ page import="com.ggz.model.Console" %>
<%@ page import="com.ggz.model.Platform" %>
<%@ include file="/view/includes/static/header.jsp" %>


<%
    Console c = request.getAttribute("console") == null ? null : (Console)request.getAttribute("console");
%>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"></h3>
    </div>
    <div class="panel-body">
        <table border="0" width="500" align="center">
            <% if( c!= null){%>
            <form action="/MC.do" method="post">

                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <H2><span class="input-group"><%=  c.getPlatform().getName() == null? "" : c.getPlatform().getName()%></span></H2>
                            <input type="hidden" name="platformId" class="form-control" value=<%=c.getPlatform().getId()%>>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Price</span>
                            <input type="text" name="price" class="form-control" value=<%= c.getPrice() == null ? "" : c.getPrice()%>>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Description</span>
                            <textarea name="description" style="resize:none; width:100%;"  rows="6" ><%= c.getDescription() == null ? "" : c.getDescription()%></textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <br />
                        <input type="submit" class="btn btn-lg btn-primary btn-block"  value ="Update Console">
                    </td>

                    <input type="hidden" name="id" value=<%=c.getId()%>>
            </form>
            <% }else{ %>
            <form action="/MC.do" method="post">
                <tr>
                    <th>New Console</th>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Name</span>
                            <select class="form-control" name="platformId">
                                <% Object[] ps = new Platform().findAll(null).toArray();
                                   for(Object p : ps){
                                       Platform pl = (Platform) p;
                                       out.println("<option value="+pl.getId()+">"+pl.getName()+"</option>");
                                   }

                                %>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Price</span>
                            <input type="text" name="price" class="form-control" value="">
                        </div>
                    </td>
                </tr>


                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Description</span>
                            <textarea name="description" style="resize:none; width:100%;"  rows="6"></textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <br />
                        <input type="submit" class="btn btn-lg btn-primary btn-block" value ="Create Console">
                    </td>

                    <input type="hidden" name="id" value=0>
            </form>
            <% } %>
            </tr>

        </table>
    </div>
</div>

<%--<h1>Checkout</h1>--%>


<%@ include file="/view/includes/static/footer.jsp" %>