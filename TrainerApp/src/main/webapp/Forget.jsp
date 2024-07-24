<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>forget password page</title>
  </head>
  <body style="background-color: pink">
  <% String success=(String)request.getAttribute("success");%>
  <% String failure=(String)request.getAttribute("failure");%>
  <% String passError=(String)request.getAttribute("passError");%>
    <center>
      <h1>Forget Password Page</h1>
      <form action="forget" method="post">
        <table>
        <%if(success!=null){ %>
        <%=success %>
        <%} %>
        <%if(failure!=null){ %>
        <%=failure %>
        <%} %>
        <%if(passError!=null){ %>
        <%=passError %>
        <%} %>
          <tr>
            <td><label for="">Phone</label></td>
            <td><input type="number" name="phone" id="" /></td>
            <br /><br />
          </tr>
          <tr>
            <td><label for="">Set Password</label></td>
            <td><input type="password" name="spassword" id="" /></td>
          </tr>
          <tr>
            <td><label for="">Confirm Password</label></td>
            <td><input type="text" name="cpassword" id="" /></td>
          </tr>
          <tr>
            <td><input type="submit" /></td>
          </tr>
          <tr>
            <td>
              <button><a href="Login.jsp">Already have an account</a></button>
            </td>
          </tr>
        </table>
      </form>
    </center>
  </body>
</html>