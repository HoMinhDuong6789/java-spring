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
	<p>form Upload</p>
	<c:url value="/upload" var="url" />
	<form method="post" action="${url}" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="file" name="file">
		<input type="file" name="file">
		<button type="submit">Submit</button>
	</form>
</body>
</html>