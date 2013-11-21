<%@ include file="/view/includes/static/header.jsp" %>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a href="/" class="navbar-brand">Gravity Game Zone</a>
    </div>
  </div>
</div>

<div class="container">
  <form id="register" action="/register.do" method="post" class="form-horizontal" >


    <div class="form-group">
      <label for="first_name" class="col-sm-3">First Name</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="first_name" name="first_name" placeholder="First Name" />
      </div>
    </div>

    <div class="form-group">
      <label for="last_name" class="col-sm-3">Last Name</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Last Name" />
      </div>
    </div>

      <div class="form-group">
          <label for="address" class="col-sm-3">Address</label>
          <div class="col-sm-6">
              <input type="text" class="form-control" id="address" name="address" placeholder="Address" />
          </div>
      </div>

    <div class="form-group">
      <label for="user_name" class="col-sm-3">Username</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id="user_name" name="user_name" placeholder="UserName" />
        </div>
    </div>

    <div class="form-group">
      <label for="password" class="col-sm-3">Password</label>
        <div class="col-sm-6">
          <input type="password" class="form-control" id="password" name="password" placeholder="Password" />
        </div>
    </div>

    <button type="submit" class="btn btn-primary" value="submit">Register</button>

  </form>
</div>
<%@ include file="/view/includes/static/footer.jsp" %>