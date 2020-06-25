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
	<form:form modelAttribute="user" method="post" action="${url}"
		enctype="multipart/form-data">
		<form:hidden path="id" />
		<p>Name</p>
		<form:input path="name" />
		<p style="color: red;">
			<form:errors path="name"></form:errors>
		</p>
		<p>Password</p>
		<form:password path="password" />
		<p style="color: red;">
			<%-- <form:errors path="password"></form:errors> --%>
		</p>
		<p>Favorites</p>
		<form:checkboxes path="favorites" items="${list}" />
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
		</br>
		<form:textarea path="about" />
		</br>
		<form:radiobutton path="acceptAgreement" value="true"
			label="Private Lisence" />
		</br>
		<form:input path="avatar" type="file" />
		</br>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>