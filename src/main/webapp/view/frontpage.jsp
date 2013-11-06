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

<div class="container">

  <div class="row row-offcanvas row-offcanvas-right">

    <div class="col-xs-12 col-sm-9">
      <div id="primary-search" class="input-group input-group-lg">
        <div class="input-group-btn">
          <button type="button" class="btn btn-default btn-lg btn-warning">Search</button>
        </div>
        <input type="text" class="form-control" />
      </div>
      <%--DO NOT REMOVE--%>
      <%--Example of a media responsive elements--%>
      <%--<p class="pull-right visible-xs">--%>
        <%--<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>--%>
      <%--</p>--%>

      <%--<div class="carousel slide" data-ride="carousel">--%>
        <%--<ol class="carousel-indicators">--%>
          <%--<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>--%>
          <%--<li data-target="#carousel-example-generic" data-slide-to="1"></li>--%>
          <%--<li data-target="#carousel-example-generic" data-slide-to="2"></li>--%>
        <%--</ol>--%>

        <%--&lt;%&ndash;Wrapper for slides&ndash;%&gt;--%>
        <%--<div class="carousel-inner">--%>
          <%--<div class="item active">--%>
            <%--Stuffs--%>
          <%--</div>--%>
        <%--</div>--%>

        <%--&lt;%&ndash;Controls&ndash;%&gt;--%>
        <%--<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">--%>
          <%--<span class="glyicon glyphicon-chevron-left"></span>--%>
        <%--</a>--%>
        <%--<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">--%>
          <%--<span class="glyicon glyphicon-chevron-right"></span>--%>
        <%--</a>--%>
      <%--</div>--%>

      <div class="jumbotron">
        <h1>Hello, world!</h1>
        <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
      </div>

      <div class="row">
        <div class="col-6 col-sm-6 col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!--/span-->
        <div class="col-6 col-sm-6 col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!--/span-->
        <div class="col-6 col-sm-6 col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!--/span-->
        <div class="col-6 col-sm-6 col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!--/span-->
        <div class="col-6 col-sm-6 col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!--/span-->
        <div class="col-6 col-sm-6 col-lg-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!--/span-->
      </div><!--/row-->
    </div><!--/span-->

    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
      <div class="list-group">
        <a href="#" class="list-group-item active">Link</a>
        <a href="#" class="list-group-item">Link</a>
        <a href="#" class="list-group-item">Link</a>
        <a href="#" class="list-group-item">Link</a>
        <a href="#" class="list-group-item">Link</a>
        <a href="#" class="list-group-item">Link</a>
        <a href="#" class="list-group-item">Link</a>
        <a href="#" class="list-group-item">Link</a>
        <a href="#" class="list-group-item">Link</a>
        <a href="#" class="list-group-item">Link</a>
      </div>
    </div><!--/span-->
  </div><!--/row-->
</div>



<%@ include file="/view/includes/static/footer.jsp" %>
