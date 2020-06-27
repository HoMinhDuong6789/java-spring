<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p>form User</p>
<c:url value="/user-edit" var="url" />
<form:form modelAttribute="user" method="post" action="${url}"
	enctype="multipart/form-data">
	<form:hidden path="id" />
	<p>Name</p>
	<form:input path="name" />
	<p style="color: red;">
		<form:errors path="name"></form:errors>
	</p>
	<p>Phone</p>
	<form:input path="phone" />
	<p style="color: red;">
		<form:errors path="phone"></form:errors>
	</p>
	<button type="submit">Submit</button>
</form:form>
