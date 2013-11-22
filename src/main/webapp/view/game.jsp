<%@ page import="com.ggz.model.activejdbc.Game" %>
<%@ include file="/view/includes/static/header.jsp" %>

<script type="text/javascript">
    $(document).ready(function () {
        $('#edit_personal').click(function () {
            if ($('#personal_icon').attr('class') == 'glyphicon glyphicon-pencil') {
                $("#personal_icon").attr('class', 'glyphicon glyphicon-ok')
                $(".peerPersonal").attr("readonly", false);
                $('#save_personal').css('visibility', '');
                return false;
            }
            else {
                $('#personal_icon').attr('class', 'glyphicon glyphicon-pencil')
                $(".peerPersonal").attr("readonly", true);
                $('#save_personal').css('visibility', 'hidden');
                return false;
            }
        });
        $('#edit_description').click(function () {
            if ($('#description_icon').attr('class') == 'glyphicon glyphicon-pencil') {
                $("#description_icon").attr('class', 'glyphicon glyphicon-ok')
                $(".peerDescription").attr("readonly", false);
                $('#save_description').css('visibility', '');
                return false;
            }
            else {
                $('#description_icon').attr('class', 'glyphicon glyphicon-pencil')
                $(".peerDescription").attr("readonly", true);
                $('#save_description').css('visibility', 'hidden');
                return false;
            }
        });
        $('#edit_contact').click(function () {
            if ($('#contact_icon').attr('class') == 'glyphicon glyphicon-pencil') {
                $("#contact_icon").attr('class', 'glyphicon glyphicon-ok')
                $(".peerContact").attr("readonly", false);
                $('#save_contact').css('visibility', '');
                return false;
            }
            else {
                $('#contact_icon').attr('class', 'glyphicon glyphicon-pencil')
                $(".peerContact").attr("readonly", true);
                $('#save_contact').css('visibility', 'hidden');
                return false;
            }
        });
        $('#save_personal').click(function (){
            document.getElementById("form_personal").submit();
            return false;
        });
        $('#save_description').click(function (){
            document.getElementById("form_description").submit();
            return false;
        });
        $('#save_contact').click(function (){
            document.getElementById("form_contact").submit();
            return false;
        });
    });
</script>


<%
    Game game = (Game) request.getAttribute("game");
    if (game == null)
    {
        game = new Game();
    }
%>
<br/>
<br/>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">GGZ</a>
        </div>
        <!--
        <ul class="nav navbar-nav">
            <li><a href="#"><img class="profile"
                                 src="/assets/images/profile/pic2.jpg"/></a></li>
            <li><a><%= game.getName()%>
            </a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                        class="glyphicon glyphicon-globe"></span><b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="http://localhost:8080/hunk">Discovery</a></li>
                    <li><a href="#">Feeds</a></li>
                </ul>

            </li>
            <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span></a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b
                        class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                    <li class="divider"></li>
                    <li><a href="#">One more separated link</a></li>
                </ul>
            </li>
        </ul>
        -->
        <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
            &nbsp &nbsp<a href="/logout.do">Logout</a>

        </form>
    </div>
</nav>

<br>

<div class="col-md-3">
    <div class="bs-sidebar well">
        <a href="#"><img class="profile2"
                         src="/assets/images/profile/pic.jpg"/></a>
    </div>

</div>
<div class="col-md-9 profile">
    <div class="col-md-10">
        <div class="profile">
            <h2>$<%=game.getPrice()%></h2>
        </div>
        <table class="table table-condensed">
            <tr>
                <td class="active">Game: <%= game.getName()%></td>
            </tr>
            <tr>
                <td class="success">Game Rating:  <%= game.getRating() %></td>
            </tr>
            <tr>
                <td class="warning">Rating: <%= game.getPgRating().get(0).getName() %></td>
            </tr>
            <tr>
                <td class="danger">Platform : <%= game.getPlatforms().get(0).getName() %> </td>
            </tr>
        </table>
    </div>
</div>

<%@ include file="/view/includes/static/footer.jsp" %>