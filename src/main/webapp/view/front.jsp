<%@ page import="com.ggz.model.activejdbc.Game" %>
<%@ page import="java.util.List" %>
<%@ include file="/view/includes/static/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar-wrapper">
  <div class="container">
    <div class="col-md-7">
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
    <div class="col-md-5">
      <div id="primary-search" class="input-group input-group-lg">
        <input type="text" class="form-control"/>

        <div class="input-group-btn">
          <button type="button" class="btn btn-default btn-lg btn-warning">
            Search
          </button>
        </div>
      </div>
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
          Game game = new Game(g);
        %>
        <div class="col-6 col-sm-6 col-lg-4 flippable">
          <h2><%= game.getName() %></h2>
          <img src="<%= game.getImage().getMediumThumb() %>" class="img-rounded box-art"/>

          <div>
            <span class="label label-primary">PC</span>
            <span class="label label-warning">PlayStation</span>
          </div>
        </div>
        <% } %>
      </div>
    </div>

    <div class="col-xs-6 col-sm-5 sidebar-offcanvas" id="sidebar"
         role="navigation">
      <h2>Top Game of the Week</h2>

      <div class="list-group">
        <% for (Game g : (List<Game>) request.getAttribute("recentAddedGames"))
        {
          Game game = new Game(g);
        %>
        <a href="#" class="list-group-item">
          <div class="pull-left">
            <img src="<%= game.getImage().getSmallThumb() %>" alt=""/>
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

<%@ include file="/view/includes/static/footer.jsp" %>
