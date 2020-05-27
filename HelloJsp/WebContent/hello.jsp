<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<p>Hello jsp</p>
	<a href="/HelloJsp/user/profile.jsp?id=1&name=j4t">Use's Profile</a>
	<%
		int x = 10;
		int y = 15;
		int z = x + y;
		
	%>
	<h1><%=z %></h1>
</body>
</html>