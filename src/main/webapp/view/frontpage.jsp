<%@ include file="/view/includes/static/header.jsp" %>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a href="/" class="navbar-brand">Gravity Game Zone</a>
    </div>

    <div class="collapse navbar-collapse">
      <form class="navbar-form navbar-right form-inline" action="/login.do"
            method="post" role="login">
        <div class="form-group">
          <input type="text" class="form-control" id="username" name="username"
                 placeholder="Username">
        </div>
        <div class="form-group">
          <input type="password" class="form-control" id="password"
                 name="password" placeholder="Password">
        </div>
        <button class="btn btn-success" type="submit">Sign In</button>
      </form>
    </div>
  </div>
</div>

<div class="navbar-wrapper">
  <div class="container">
    <nav class="navbar navbar-inverse" role="navigation">
      <ul class="nav navbar-nav">
        <li><a href="">PC</a></li>
        <li><a href="">Xbox</a></li>
        <li><a href="">PlayStation</a></li>
        <li><a href="">Nintendo</a></li>
      </ul>
    </nav>
  </div>
</div>

<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="item active">
      <img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide" alt="First slide">
      <div class="container">
        <div class="carousel-caption">
          <h1>Example headline.</h1>
          <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
        </div>
      </div>
    </div>
    <div class="item">
      <img data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide" alt="Second slide">
      <div class="container">
        <div class="carousel-caption">
          <h1>Another example headline.</h1>
          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
        </div>
      </div>
    </div>
    <div class="item">
      <img data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide" alt="Third slide">
      <div class="container">
        <div class="carousel-caption">
          <h1>One more for good measure.</h1>
          <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
        </div>
      </div>
    </div>
  </div>
  <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div><!-- /.carousel -->

<div class="container">

  <div class="row">

    <div class="col-md-8">


      <div id="primary-search" class="input-group input-group-lg">
        <div class="input-group-btn">
          <button type="button" class="btn btn-default btn-lg btn-warning">
            Search
          </button>
        </div>
        <input type="text" class="form-control"/>
      </div>
      <%--DO NOT REMOVE--%>
      <%--Example of a media responsive elements--%>
      <%--<p class="pull-right visible-xs">--%>
      <%--<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>--%>
      <%--</p>--%>
    </div>
  </div>

  <div class="row">
    <div class="col-md-3">
      <h2>Heading</h2>

      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
        tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
        massa justo sit amet risus. Etiam porta sem malesuada magna mollis
        euismod. Donec sed odio dui. </p>

      <p><a class="btn btn-default" href="#" role="button">View
        details &raquo;</a></p>
    </div>
    <!--/span-->
    <div class="col-md-3">
      <h2>Heading</h2>

      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
        tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
        massa justo sit amet risus. Etiam porta sem malesuada magna mollis
        euismod. Donec sed odio dui. </p>

      <p><a class="btn btn-default" href="#" role="button">View
        details &raquo;</a></p>
    </div>
    <!--/span-->
    <div class="col-md-3">
      <h2>Heading</h2>

      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
        tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
        massa justo sit amet risus. Etiam porta sem malesuada magna mollis
        euismod. Donec sed odio dui. </p>

      <p><a class="btn btn-default" href="#" role="button">View
        details &raquo;</a></p>
    </div>
    <!--/span-->
    <div class="col-md-3">
      <h2>Heading</h2>

      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
        tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
        massa justo sit amet risus. Etiam porta sem malesuada magna mollis
        euismod. Donec sed odio dui. </p>

      <p><a class="btn btn-default" href="#" role="button">View
        details &raquo;</a></p>
    </div>
    <!--/span-->
    <div class="col-md-3">
      <h2>Heading</h2>

      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
        tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
        massa justo sit amet risus. Etiam porta sem malesuada magna mollis
        euismod. Donec sed odio dui. </p>

      <p><a class="btn btn-default" href="#" role="button">View
        details &raquo;</a></p>
    </div>
    <!--/span-->
    <div class="col-md-3">
      <h2>Heading</h2>

      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus,
        tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum
        massa justo sit amet risus. Etiam porta sem malesuada magna mollis
        euismod. Donec sed odio dui. </p>

      <p><a class="btn btn-default" href="#" role="button">View
        details &raquo;</a></p>
    </div>
  </div>
</div>


<%@ include file="/view/includes/static/footer.jsp" %>
