<%@ page import="com.ggz.model.Game" %>
<%@ page import="com.ggz.model.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ggz.model.Platform" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="/view/includes/static/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
  $(document).ready(function() {
    $('#submit').click(function(event)
    {
      var e = $('#submit').val();
      $.post('cart.do', {
        email : e
      }, function(responseText) {
        var e = $('#cart').val();
        $('#cart').text(responseText);
      });
    });
  });
  $(function() {
    $("ul.dropdown-menu").on("click", "[data-Delete]", function(e) {
      e.stopPropagation();
      deleteRow(this);
    });
  });


</script>
<%
   ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
  int i = 1;
%>
<div class="navbar-wrapper">
  <div class="container">
    <div class="col-md-8">
      <nav class="navbar navbar-inverse" role="navigation">
        <div class="navbar-header">
          <a href="/" class="navbar-brand">Gravity Game Zone</a>
        </div>

        <ul class="nav navbar-nav">
          <li><a href="" class="item active">News</a></li>
          <li><a href="">PC</a></li>
          <li><a href="">Xbox</a></li>
          <li><a href="">PlayStation</a></li>
          <li><a href="">Nintendo</a></li>
          <li>
            <a class="removefromcart" id="cart-box" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
            <ul class="dropdown-menu">
              <li>
                <div>
                    <table id="POITable" class="table table-striped" style="width:500px;">
                     <thead>
                      <tr>
                        <td>Item</td>
                        <td>Item name</td>
                        <td>Price</td>
                        <td></td>
                      </tr>
                      </thead>
                          <% for (Game g : (List<Game>)request.getAttribute("g")) { %>
                      <tbody>
                      <tr>
                        <td><%=g.getId() == null ? "" : ++i%></td>
                        <td><p><%=g.getName() == null? "" : g.getName()%></p></td>
                        <td><p><%=g.getPrice() == null? "" : g.getPrice()%></p></td>
                        <td><a href="#" data-Delete="true"><span class="glyphicon glyphicon-remove"></span></a></td>
                      </tr>
                      </tbody>
                      <% }%>
                    </table>
                    <div class="col-md-offset-8">
                      <p>Total: <%=cart.getTotalPrice() == null? "": cart.getTotalPrice()%></p>
                    </div>
                        <div class="row">
                          <div class="col-md-3 col-md-offset-8">
                            <button <%if (cart.getTotalPrice()==0.0){ %>style="visibility:hidden;" <%}%> type="button" class="btn btn-default btn-success" onClick="parent.location='checkout'">
                              Checkout
                            <span class="badge"><span class="glyphicon glyphicon-chevron-right"></span></span>
                            </button>
                          </div>
                        </div>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
    </div>

    <div class="col-md-4">
        <form action="/search.do" method="post">
      <div id="primary-search" class="input-group input-group-lg">

            <input type="text" class="form-control" name="name" placeholder="Name" />

            <div class="input-group-btn">
                <button type="submit" class="btn btn-default btn-lg btn-warning">
                    Search
                </button>
            </div>

      </div>
            </form>
    </div>
  </div>
</div>

<!-- Carousel
================================================== -->
<div id="ggz-front-carousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="item active">
      <div class="carousel-imageholder">
        <img src="/assets/images/front/ghosts.jpg" alt="Call of Duty: Ghost" />
      </div>

      <div class="container">
        <div class="carousel-caption">
          <h1>Call of Duty: Ghosts</h1>
          <p>The 2013 installment in the long-running military FPS series, developed by Infinity Ward and an assortment of other studios.</p>
        </div>
      </div>
    </div>
    <div class="item">
      <div class="carousel-imageholder">
        <img src="/assets/images/front/hearthstone.jpg" alt="Hearthstone beta" />
      </div>

      <div class="container">
        <div class="carousel-caption">
          <h1>Hearthstone: Heroes of Warcraft</h1>

          <p>A Free-to-Play card collection/strategy game by Blizzard Entertainment set in the Warcraft universe.</p>
        </div>
      </div>
    </div>
    <div class="item">
      <div class="carousel-imageholder">
        <img src="/assets/images/front/nfs.jpg" alt="Need for Speed: Rivals" />
      </div>

      <div class="container">
        <div class="carousel-caption">
          <h1>Need for Speeds: Rivals</h1>
          <p>A cross-gen open-world driving game set in a fictional Redview County.</p>
        </div>
      </div>
    </div>
  </div>
  <a class="left carousel-control" href="#ggz-front-carousel" data-slide="prev"><span
      class="glyphicon glyphicon-chevron-left"></span></a>
  <a class="right carousel-control" href="#ggz-front-carousel"
     data-slide="next"><span
      class="glyphicon glyphicon-chevron-right"></span></a>
</div>
<!-- /.carousel -->

<div class="container">
  <div class="row row-offcanvas row-offcanvas-right">
    <div class="col-xs-12 col-sm-7">
      <div class="row">
      <% for (Game game : (List<Game>)request.getAttribute("recentAddedGames")) { %>
        <div class="col-6 col-sm-6 col-lg-4 flippable" data-id="<%= game.getId() %>">
          <h2><%= game.getName() %></h2>
          <div class="box-art-container">
            <img src="<%= game.getImage().getMediumUrl() %>" class="img-rounded box-art"/>
          </div>
          <div>
            <form action="/cart.do" method="post">
              <%
                boolean xbox = false;
                boolean playstation = false;
                boolean pc = false;
                boolean mobile = false;
                Platform p = game.getPlatform();
                if(p != null){
                if (StringUtils.containsIgnoreCase(p.getName(), "xbox") && !xbox) { %>
                  <span class="label label-success">Xbox</span>
                <% xbox = true;
                } else if (StringUtils.containsIgnoreCase(p.getName(), "playstation") && !playstation) { %>
                  <span class="label label-primary">PlayStation</span>
                <% playstation = true;
                } else if (StringUtils.containsIgnoreCase(p.getName(), "pc") && !pc) { %>
                  <span class="label label-warning">PC</span>
                <% pc = true;
                } else if (!mobile) { %>
                  <span class="label label-danger">Mobile</span>
              <% mobile = true; }} %>
              <%List<Game> games = (List<Game>)request.getAttribute("g"); %>
              <input type="hidden" name="game_id" value="<%= game.getId() %>" />
              <input type="hidden" name="cart_id" value="<%= cart.getId() %>" />
              <input type="hidden" name="games" value="<%=games%>" />
              <button type="submit" class="btn btn-xs btn-success" >Add to Cart</button>
            </form>
          </div>
        </div>
        <% } %>
      </div>
    </div>
    <div class="col-xs-6 col-sm-5 sidebar-offcanvas" id="sidebar"
         role="navigation">
      <h2>Top Game of the Week</h2>

      <div class="list-group">
        <% for (Game game : (List<Game>)request.getAttribute("topGamesOfTheWeek")) { %>
        <a href="/game.do?id=<%= game.getId() %>" class="list-group-item">
          <div class="pull-left">
            <img src="<%= game.getImage().getTinyUrl() %>" alt=""/>
          </div>
          <h4><%= game.getName() %></h4>
          <h6>
            <span class="label label-primary">PC</span>
            <span class="label label-warning">PlayStation</span>
          </h6>
          <p><%= game.getDeck() %></p>
        </a>
        <% } %>
      </div>
    </div>
  </div>
</div>
<footer>
  2013 Sunny Delight
</footer>

  <script type="text/javascript">
    var table = document.getElementById('POITable'),
        tbody = table.getElementsByTagName('tbody')[0],
        clone = tbody.rows[0].cloneNode(true);

    function deleteRow(el) {
      var i = el.parentNode.parentNode.rowIndex;
      table.deleteRow(i);
      while (table.rows[i]) {
        updateRow(table.rows[i], i, false);
        i++;
      }
    }
  </script>
<%@ include file="/view/includes/static/footer.jsp" %>
