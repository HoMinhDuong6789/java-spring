<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@	taglib uri='http://www.springframework.org/security/tags'
	prefix='security'%>

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal" var="user" />
Wellcome, ${user.username}
	<a href="<c:url value='/dang-xuat'></c:url>">Thoat</a>
</security:authorize>

<br />
<a href="<c:url value='/admin/user-insert'></c:url>">Add new user</a>


<br />
<a href="<c:url value='/product-detail/${item.productDTO.id}'></c:url>">Detail</a>
<br />
<a href="<c:url value='/product-edit/${item.productDTO.id}'></c:url>">Edit</a>
<br />
<a href="<c:url value='/list-product'></c:url>">List Product</a>
<br />
<a href="<c:url value='/view-cart/${item.productDTO.id}'></c:url>">View
	Cart</a>