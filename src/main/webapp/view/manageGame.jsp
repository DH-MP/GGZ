<%@ page import="com.ggz.model.Game" %>
<%@ include file="/view/includes/static/header.jsp" %>


<%
    Game g = request.getAttribute("game") == null ? null : (Game)request.getAttribute("game");
%>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"></h3>
    </div>
    <div class="panel-body">
        <table border="0" width="500" align="center">
            <form action="/MG.do" method="post">
                <tr>
                    <th>Game</th>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Name</span>
                            <input type="text" name="name" class="form-control" value=<%= g == null ? "" : g.getName()%>>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Price</span>
                            <input type="text" name="price" class="form-control" value=<%= g == null ? "" : g.getPrice()%>>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Rating</span>
                            <input type="text" name="rating" class="form-control" value=<%= g == null ? "" : g.getRating()%>>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Release Date</span>
                            <input type="text" name="releaseDate" class="form-control" value=<%= g == null ? "" : g.getReleaseDate()%>>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Deck</span>
                            <input type="text" name="deck" class="form-control">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Deck</span>
                            <input type="text" name="deck" class="form-control" value=<%= g == null ? "" : g.getDeck()%>>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">Description</span>
                            <input type="text" name="description" class="form-control" value=<%= g == null ? "" : g.getDescription()%>>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <br />
                        <input type="submit" class="btn btn-lg btn-primary btn-block" />
                    </td>

                <input type="hidden" name="id" value=<%=g == null ? 0: g.getId()%> >
            </form>
            </tr>

        </table>
    </div>
</div>

<%--<h1>Checkout</h1>--%>


<%@ include file="/view/includes/static/footer.jsp" %>