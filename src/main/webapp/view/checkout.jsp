<%@ include file="/view/includes/static/header.jsp" %>
<% if (session.getAttribute("user") == null)
    response.sendRedirect("/login");
%>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Checkout</h3>
  </div>
  <div class="panel-body">
    <table border="0" width="500" align="center">
      <form action="/checkout.do" method="post" id="checkoutForm">
        <fieldset>
        <tr>
          <th>Shipping Address</th>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Name</span>
              <input type="text" name="name" class="form-control" >
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Address</span>
              <input type="text" name="address" class="form-control" required>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Postal Code/Zipcode</span>
              <input type="text" name="postal" class="form-control" >
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Province/State</span>
              <input type="text" name="province" class="form-control" >
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Country</span>
              <input type="text" name="country" class="form-control" >
            </div>
          </td>
        </tr>
        <tr>
          <th>Payment method</th>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Credit card type</span>
              <select name="creditcard" class="form-control">
                <option value="master">MasterCard</option>
                <option value="visa">Visa</option>
                <option value="amex">American Express</option>
                <option value="discover">Discover</option>
              </select>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Card number</span>
              <input type="text" name="cardnumber" class="form-control"  maxlength="10" required>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Pin number</span>
              <input type="text" name="sec" class="form-control" >
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Card holder's name</span>
              <input type="text" name="ccname" class="form-control" >
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="input-group input-group-sm">
              <span class="input-group-addon">Expiration date</span>
              <input type="text" name="expirationdate" class="form-control" placeholder="MM/DD/YY" >
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <br />
            <button type="submit" class="btn btn-lg btn-primary btn-block" >Checkout order</button>
          </td>
        </fieldset>
      </form>
      </tr>

    </table>
  </div>
</div>
<script>
  $("#checkoutForm").validate();
</script>
<%@ include file="/view/includes/static/footer.jsp" %>