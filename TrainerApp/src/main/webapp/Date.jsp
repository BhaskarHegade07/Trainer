<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Date d=new Date(); %>  <!-- scriptlet tag (to write java code i.e, object) -->
<h1><%=d %></h1>    <!-- Expression tag to display the content of java variable -->
</body>
</html>