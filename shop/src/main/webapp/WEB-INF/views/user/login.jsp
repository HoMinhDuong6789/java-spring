<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<p>Login Page</p>
<c:url value="/login" var="url" />
<form action="${url}" method="post">
	<input name="username" placeholder="Username" type="text"> 
	<input name="password" type="password" placeholder="password">
	<button type="submit">Login</button>
</form>
