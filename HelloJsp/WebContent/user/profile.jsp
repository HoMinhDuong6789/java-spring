<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
	%>
	<h1>id:<%=id %></h1>
	<h1>Wellcome:<%=name %></h1>
	<a href="logout.jsp">Logout</a>
</body>
</html>