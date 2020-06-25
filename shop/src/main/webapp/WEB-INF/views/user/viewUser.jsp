<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Detail</title>
<link href='<c:url value="/static/css.style.css"></c:url>'>
<script type="text/javascript"
	src='<c:url value="/static/css.style.css"></c:url>'></script>
</head>
<body>
	<p>User Information</p>
	<p>Id: ${user.id}</p>
	<p>Name: ${user.name}</p>
	<p>Password: ${user.phone}</p>
</body>
</html>