<%@ page import="com.ggz.model.Game" %>
<%@ page import="com.ggz.model.PgRating" %>
<%@ page import="com.ggz.model.Platform" %>
<%@ include file="/view/includes/static/header.jsp" %>


<%
    Game g = request.getAttribute("game") == null ? null : (Game)request.getAttribute("game");
%>

<div class="panel panel-default">

    <div class="panel-heading">
        <h3 class="panel-title"></h3>
    </div>
    <div class="panel-body">
        <div class="bs-sidebar" style="float:left">
            <% if( g!= null){%>
                <a href="#">
                   <img class="profile2"
                   src=<%= g.getImage() == null ? "http://png-2.findicons.com/files/icons/2380/android_style_icons_r1/512/gallery.png" : g.getImage().getTinyUrl()%>>
                </a>
            <%}else{%>
                <a href="#">
                    <img class="profile2"
                         src="http://png-2.findicons.com/files/icons/2380/android_style_icons_r1/512/gallery.png""%>>
                </a>
            <%}%>
        </div>
        <table border="0" width="500" align="center" style="margin-left: 100px; float:left">
            <% if( g!= null){%>
                <form action="/MG.do" method="post">
                    <tr>
                        <th>Game</th>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Name</span>
                                <input type="text" name="name" class="form-control" value=<%=  g.getName() == null? "" : g.getName()%>>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Price</span>
                                <input type="text" name="price" class="form-control" value=<%= g.getPrice() == null ? "" : g.getPrice()%>>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Rating</span>
                                <input type="text" name="rating" class="form-control" value=<%=  g.getRating()==null ? "" : g.getRating()%>>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Release Date</span>
                                <input type="text" name="releaseDate" class="form-control" value=<%= g.getReleaseDate() == null ? "" : g.getReleaseDate()%>>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">PG-Rating</span>
                                <select class="form-control" name="pgRatingId">
                                    <option value="">N/A</option>
                                    <% Object[] pr = new PgRating().findAll(null).toArray();
                                        for(Object p : pr){
                                            PgRating pl = (PgRating) p;
                                            if(pl.getId() == g.getPgRatingId()){
                                                out.println("<option value="+pl.getId()+" selected=\"selected\">"+pl.getName()+"</option>");
                                            }else{
                                                out.println("<option value="+pl.getId()+">"+pl.getName()+"</option>");
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Platform</span>
                                <select class="form-control" name="platformId">
                                    <option value="">N/A</option>
                                    <% Object[] ps = new Platform().findAll(null).toArray();
                                        for(Object p : ps){
                                            Platform pl = (Platform) p;
                                            if(pl.getId() == g.getPlatformId()){
                                                out.println("<option value="+pl.getId()+" selected=\"selected\">"+pl.getName()+"</option>");
                                            }else{
                                                out.println("<option value="+pl.getId()+">"+pl.getName()+"</option>");
                                            }
                                        }

                                    %>
                                </select>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Deck</span>
                                <input type="text" name="deck" class="form-control" value=<%= g.getDeck() == null ? "" : g.getDeck()%>>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Description</span>
                                <textarea name="description" style="resize:none; width:100%;"  rows="6" ><%= g.getDescription() == null ? "" : g.getDescription()%></textarea>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Image Tiny URL</span>
                                <input type="text" name="imageTinyURL" class="form-control" value="<%= g.getImage() == null ? "" : g.getImage().getTinyUrl()%>">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Image Medium URL</span>
                                <input type="text" name="imageMediumURL" class="form-control" value="<%= g.getImage() == null ? "" : g.getImage().getMediumUrl()%>">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Image Large URL</span>
                                <input type="text" name="imageLargeURL" class="form-control" value="<%= g.getImage() == null ? "" : g.getImage().getLargeUrl()%>">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <br />
                            <input type="submit" class="btn btn-lg btn-primary btn-block" />
                        </td>

                    <input type="hidden" name="id" value=<%=g.getId()%> >
                </form>
            <% }else{ %>
                <form action="/MG.do" method="post">
                    <tr>
                        <th>Game</th>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Name</span>
                                <input type="text" name="name" class="form-control" value="">
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
                                <span class="input-group-addon">Rating</span>
                                <input type="text" name="rating" class="form-control" value="">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Name</span>
                                <select class="form-control" name="pgRatingId">
                                    <option value="">N/A</option>
                                    <% Object[] pr = new PgRating().findAll(null).toArray();
                                        for(Object p : pr){
                                            PgRating pl = (PgRating) p;
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
                                <span class="input-group-addon">Name</span>
                                <select class="form-control" name="platformId">
                                    <option value="">N/A</option>
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
                                <span class="input-group-addon">Release Date</span>
                                <input type="text" name="releaseDate" class="form-control" value="">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Deck</span>
                                <input type="text" name="deck" class="form-control" value="">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Description</span>
                                <textarea name="description" style="resize:none; width:100%;"  rows="6" > </textarea>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Image Tiny URL</span>
                                <input type="text" name="imageTinyURL" class="form-control" value="">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Image Medium URL</span>
                                <input type="text" name="imageMediumURL" class="form-control" value="">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon">Image Large URL</span>
                                <input type="text" name="imageLargeURL" class="form-control" value="">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <br />
                            <input type="submit" class="btn btn-lg btn-primary btn-block" />
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