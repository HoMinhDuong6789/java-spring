<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/static/css.style.css"></c:url>'>
<script type="text/javascript" src='<c:url value="/static/css.style.css"></c:url>'></script>
</head>
<body>
	<p>Hello ${msg}</p>
	<img alt="avatar" src='<c:url value='/static/image/link.jpg'></c:url>'>
</body>
</html>