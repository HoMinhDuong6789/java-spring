<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<br />
<a href="<c:url value='/user-insert'></c:url>">Add new user</a>


<br/>
<a href="<c:url value='/product-detail/${item.productDTO.id}'></c:url>">Detail</a>
<br/>
<a href="<c:url value='/product-edit/${item.productDTO.id}'></c:url>">Edit</a>
<br/>
<a href="<c:url value='/list-product'></c:url>">List Product</a>
<br/>
<a href="<c:url value='/view-cart/${item.productDTO.id}'></c:url>">View
	Cart</a>