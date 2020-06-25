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
	<p>User Information</p>
	<p>Name: ${user.name}</p>
	<p>Password: ${user.password}</p>
	<p>Id: ${user.id}</p>

	<p>Gender: ${user.gender}</p>
	<p>About: ${user.about}</p>
	<p>AcceptAgreement: ${user.acceptAgreement}</p>
	<p>Favorites:</p>
<p>File Information</p>
	<p>Name: ${user.avatar.getOriginalFilename()}
	<%-- <c:forEach items="${user.favorites }" var="item">
		<p>${item}</p>
	</c:forEach> --%>
</body>
</html>