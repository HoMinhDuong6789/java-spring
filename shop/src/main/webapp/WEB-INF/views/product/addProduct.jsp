<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<p>form User</p>
<c:url value="/product-insert" var="url" />
<form:form modelAttribute="product" method="post" action="${url}"
	enctype="multipart/form-data">
	<form:hidden path="id" />
	<p>Name</p>
	<form:input path="name" />
	<p>Price</p>
	<form:input path="price" />
	<button type="submit">Submit</button>
</form:form>