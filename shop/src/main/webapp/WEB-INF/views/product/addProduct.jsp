<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<p>form Product</p>
<c:url value="/product-insert" var="url" />
<form:form modelAttribute="product" method="post" action="${url}"
	enctype="multipart/form-data">
	<form:hidden path="id" />
	<p>
		<spring:message code="product.name"></spring:message>
	</p>
	<form:input path="name" />
	<p>
		<spring:message code="product.price"></spring:message>
	</p>
	<form:input path="price" />
	<p>
		Image
	</p>
	<form:input type="file" path="file" />


	<button type="submit">Submit</button>
</form:form>