<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.TrainerApp.DTO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body bgcolor="grey">
<center>

<%Student s=(Student)request.getAttribute("student"); %>
<%if (s!=null){ %>
<table>
<tr>
<td><h1>Welcome <%=s.getName()%></h1></td>
</tr>

<tr>
<td>Phone Number : </td>
<td><%=s.getPhone()%></td>
</tr>
<tr>
<td>Mail</td>
<td><%=s.getMail()%></td>
</tr>
<tr>
<td>Branch</td>
<td><%=s.getBranch()%></td>
</tr>
<tr>
<td>Location</td>
<td><%=s.getLocation()%></td>
</tr>
<tr>
<td><button type="submit">Update Account</button></td>
</tr>

</table>
<%} %>
</center>
</body>
</html>