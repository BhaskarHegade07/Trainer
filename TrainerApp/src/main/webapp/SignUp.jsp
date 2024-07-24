<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.TrainerApp.DTO.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: aqua">
<%String error1=(String)request.getAttribute("error1"); %>
<%String mismatch=(String)request.getAttribute("mismatch"); %>
<%String signupSuccess=(String)request.getAttribute("signupSuccess"); %>
<%Student s=new Student(); %>
<center>
    <h1>SignUp page</h1>
    <form action="signup" method="post">
    <%if(error1!=null) {%>
      <%=error1%>
      <%} %>
      <%if(mismatch!=null){ %>
      <%=mismatch %>
      <%} %>
      <%if(signupSuccess!=null){ %>
      <%=signupSuccess %>
      
      <%} %>
      <table>
        <tr>
          <td><label for="">Name</label></td>
          <td><input type="text" name="Name" id="" /><br /><br /></td>
        </tr>
        <tr>
          <td><label for="">Phone</label></td>
          <td><input type="number" name="Phone" id="" /><br /><br /></td>
        </tr>
        <tr>
          <td><label for="">Mail</label></td>
          <td><input type="email" name="Mail" id="" /><br /><br /></td>
        </tr>
        <tr>
          <td><label for="">Branch</label></td>
          <td><input type="text" name="Branch" id="" /><br /><br /></td>
        </tr>
        <tr>
          <td><label for="">Location</label></td>
          <td><input type="text" name="Location" id="" /><br /><br /></td>
        </tr>
        <tr>
          <td><label for="">SetPassword</label></td>
          <td>
            <input type="password" name="Password" id="" /><br /><br />
          </td>
        </tr>
        <tr>
          <td><label for="">ConfirmPassword</label></td>
          <td>
            <input type="password" name="ConfirmPassword" id="" /><br /><br />
          </td>
        </tr>
       
        <tr>
          <td><input type="submit" value="SignUp" /></td>
        </tr>
        
        <tr>
        <td><a href="Login.jsp">Already have an Account</a></td>
        </tr>
      
      </table>
      </center>
    </form>
  </body>
</html>