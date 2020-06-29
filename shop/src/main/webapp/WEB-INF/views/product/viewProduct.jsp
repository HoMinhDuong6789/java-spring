<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<p>Product Information</p>
	<p>Id: ${product.id}</p>
	<p>Name: ${product.name}</p>
	<p>Price: ${product.price}</p>
	<p><img width="200px" height="200px" src="<c:url value='/file/${product.image_url}'/>"/></p>
</body>