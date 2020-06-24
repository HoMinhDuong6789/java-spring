<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/static/css/style.css"></c:url>'>

<script type="text/javascript" src='<c:url value="/static/js/script.js"></c:url>'></script>
</head>
<body>
	<p>Hello ${person.name}</p>
	<p>form User</p>
	<%-- 	<form:form modelAttribute="user" method="post" action="#">
		<form:input path="name" />
		<button type="submit"></button>
	</form:form>--%>
	<img alt="avatar" src='<c:url value='/static/image/link.jpg'></c:url>'>
</body>
</html>