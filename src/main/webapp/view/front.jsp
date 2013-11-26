<%@ page import="com.ggz.model.Game" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
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
  $(function() {
    $("ul.dropdown-menu").on("click", "[data-Add]", function(e) {
      e.stopPropagation();
      insRow();
    });
  });


</script>
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
                      <tbody>
                      <tr>
                        <td>1</td>
                        <td><p>itemName</p></td>
                        <td><p>itemPrice</p></td>
                        <td><a href="#" data-Delete="true"><span class="glyphicon glyphicon-remove"></span></a></td>
                      </tr>
                      </tbody>
                    </table>
                    <div class="col-md-offset-8">
                      <p>Total: 84.98</p>
                    </div>
                      <div class="well">
                        <div class="row">
                          <div class="col-md-3">
                            <button type="button" class="btn btn-primary" data-Add="true">Add</button>
                          </div>
                          <div class="col-md-3 col-md-offset-5">
                            <button type="button" class="btn btn-default btn-success" onClick="parent.location='checkout'">
                              Checkout
                            <span class="badge"><span class="glyphicon glyphicon-chevron-right"></span></span>
                            </button>
                          </div>
                        </div>
                      </div>
                </div>
              </li>
            </ul>
          </li>
        </ul>

        <%--<div class="collapse navbar-collapse">--%>
        <%--<form class="navbar-form navbar-right form-inline" action="/search.do"--%>
        <%--method="post" role="search">--%>
        <%--<div class="form-group">--%>
        <%--<input type="text" class="form-control" id="q" name="q"--%>
        <%--placeholder="Search..."/>--%>
        <%--</div>--%>
        <%--<button id="search" class="btn btn-warning" type="submit"><span--%>
        <%--class="glyphicon glyphicon-search"></span></button>--%>
        <%--</form>--%>
        <%--</div>--%>
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
      <img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide"
           alt="First slide">

      <div class="container">
        <div class="carousel-caption">
          <h1>Example headline.</h1>

          <p>Note: If you're viewing this page via a <code>file://</code> URL,
            the "next" and "previous" Glyphicon buttons on the left and right
            might not load/display properly due to web browser security rules.
          </p>

          <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up
            today</a></p>
        </div>
      </div>
    </div>
    <div class="item">
      <img data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide"
           alt="Second slide">

      <div class="container">
        <div class="carousel-caption">
          <h1>Another example headline.</h1>

          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec
            id elit non mi porta gravida at eget metus. Nullam id dolor id nibh
            ultricies vehicula ut id elit.</p>

          <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn
            more</a></p>
        </div>
      </div>
    </div>
    <div class="item">
      <img data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide"
           alt="Third slide">

      <div class="container">
        <div class="carousel-caption">
          <h1>One more for good measure.</h1>

          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec
            id elit non mi porta gravida at eget metus. Nullam id dolor id nibh
            ultricies vehicula ut id elit.</p>

          <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse
            gallery</a></p>
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
      <% for (Game g : (List<Game>) request.getAttribute("recentAddedGames"))
      {
          Game game = g;
      %>
        <div class="col-6 col-sm-6 col-lg-4 flippable" data-id="<%= game.getId() %>">
          <h2><%= game.getName() %></h2>
          <div class="box-art-container">
            <img src="<%= game.getImage().getMediumUrl() %>" class="img-rounded box-art"/>
          </div>
          <div>
            <span class="label label-primary">PC</span>
            <span class="label label-warning">PlayStation</span>
            <span class="label label-success">Add to Cart</span>
          </div>
        </div>
        <% } %>
      </div>
    </div>
    <p id="classifier">Project</p>
    <div class="col-xs-6 col-sm-5 sidebar-offcanvas" id="sidebar"
         role="navigation">
      <h2>Top Game of the Week</h2>

      <div class="list-group">
          <% for (Game g : (List<Game>) request.getAttribute("recentAddedGames"))
          {
              Game game = g;
          %>
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
<form action="" >
  <input type="button" id="submit" value="something" />
  <div id="cart"></div>
</form>
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

    function insRow() {
      var new_row = updateRow(clone.cloneNode(true), ++tbody.rows.length, true);
      tbody.appendChild(new_row);
    }

    function updateRow(row, i, reset) {
      row.cells[0].innerHTML = i;
      var gameName = document.getElementById("gameName");
      var gamePrice = document.getElementById("gamePrice");
//      var inp1 = row.cells[1].getElementsByTagName('p')[0];
//      var inp2 = row.cells[2].getElementsByTagName('p')[0];
//      inp1.id = i;
//      inp2.id =  i;
      gameName.id = i;
      gamePrice.id = i;
      if (reset) {
//        inp1.value = inp2.value = '';
          gameName.value = gamePrice.value = '';
      }
      return row;
    }

  </script>
<%@ include file="/view/includes/static/footer.jsp" %>
