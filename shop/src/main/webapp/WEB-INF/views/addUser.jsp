<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/static/css.style.css"></c:url>'>
<script type="text/javascript"
	src='<c:url value="/static/css.style.css"></c:url>'></script>
</head>
<body>
	<p>form User</p>
	<c:url value="/adduser" var="url" />
	<form:form modelAttribute="user" method="post" action="${url}">
		<form:input path="name" />
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>