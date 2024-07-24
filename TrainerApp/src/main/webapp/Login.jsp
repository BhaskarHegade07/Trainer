<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Login Page</title>
    <style></style>
  </head>
  <body style="background-color: chartreuse">
  <%String error=(String)request.getAttribute("error"); %>
  
    <center>
      <h1>Login page</h1>
      <form action="login" method="post">
      <%if(error!=null) {%>
      <%=error%>
      <%} %>
        <table>
          <tr>
            <td><label>Enter the id : </label></td>
            <td><input type="text" name="id" /><br /><br /></td>
          </tr>
          <tr>
            <td><label>Enter the password : </label></td>
            <td><input type="password" name="password" /><br /></td>
          </tr>
          <tr>
            <td><input type="submit" value="Login" /></td>
          </tr>
          <tr>
            <td><button><a href="Forget.jsp">Forget Password</a></button></td>
            </tr>
            <tr>
            <td><button><a href="SignUp.jsp">Create new account</a></button></td>
          </tr>
        </table>
      </form>
    </center>
    
  </body>
</html>
