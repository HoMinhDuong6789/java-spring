<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Users</title>
<link href='<c:url value="/static/css.style.css"></c:url>'>
<script type="text/javascript"
	src='<c:url value="/static/css.style.css"></c:url>'></script>
</head>
<body>
	<p>List Users</p>
	<hr/>
	<a href="<c:url value='/user-insert'></c:url>">Add new user</a>
	</br>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Action</th>
		</tr>


		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.phone}</td>
				<!--19.16  -->
				<td><a href="<c:url value='/user-detail/${user.id}'></c:url>">Detail</a>
					<a href="<c:url value='/user-delete/${user.id}'></c:url>">Delete</a>
					<a href="<c:url value='/user-edit/${user.id}'></c:url>">Edit</a>				
				</td>
				
			</tr>
		</c:forEach>

	</table>
</body>
</html>