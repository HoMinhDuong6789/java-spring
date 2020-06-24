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
		<form:hidden path="id" />
		<p>Name</p>
		<form:input path="name" />
		<p>Password</p>
		<form:password path="password" />
		<p>Favorites</p>
		<form:checkboxes path="favorites" items="${list}"/>
		<%-- <form:checkbox path="favorites" value="Listen to Music" label="Music" />
		<form:checkbox path="favorites" value="Read book" label="Read" />
		<form:checkbox path="favorites" value="Sport" label="Sport" />
		<form:checkbox path="favorites" value="Travel" label="Travel" /> --%>
		<p>Gender</p>
		<form:select path="gender">
			<form:option value="Male">Male</form:option>
			<form:option value="Female">Female</form:option>
		</form:select>
		<p>About</p>
		<form:textarea path="about" />
		<form:radiobutton path="acceptAgreement" value="true"
			label="Private Lisence" />
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>