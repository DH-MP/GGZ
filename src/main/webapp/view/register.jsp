<%@ include file="/view/includes/static/header.jsp" %>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a href="/" class="navbar-brand">Gravity Game Zone</a>
    </div>
  </div>
</div>

<div class="container">
  <form class="form-horizontal" action="" role="form">
    <div class="form-group">
      <label for="first-name" class="col-sm-3">First Name</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="first-name" name="first-name" placeholder="First Name" />
      </div>
    </div>

    <div class="form-group">
      <label for="last-name" class="col-sm-3">First Name</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="last-name" name="last-name" placeholder="Last Name" />
      </div>
    </div>

    <div class="form-group">
      <label for="email" class="col-sm-3">Email</label>
      <div class="col-sm-6">
        <input type="email" class="form-control" id="email" name="email" placeholder="Email" />
      </div>
    </div>

    <div class="form-group">
      <label for="username" class="col-sm-3">Username</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="username" name="email" placeholder="Email" />
        </div>
    </div>

    <div class="form-group">
      <label for="password" class="col-sm-3">Password</label>
        <div class="col-sm-6">
          <input type="password" class="form-control" id="password" name="email" placeholder="Password" />
        </div>
    </div>
  </form>
</div>
<%@ include file="/view/includes/static/footer.jsp" %>