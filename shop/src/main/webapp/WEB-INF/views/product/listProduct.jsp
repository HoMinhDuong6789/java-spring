<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<p>List Product</p>
<hr />
<a href="<c:url value='/product-insert'></c:url>">Add new product</a>
<br/>
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Action</th>
	</tr>


	<c:forEach items="${products}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<!--19.16  -->
			<td><a
				href="<c:url value='/product-detail/${product.id}'></c:url>">Detail</a>
				<a href="<c:url value='/product-delete/${product.id}'></c:url>">Delete</a>
				<a href="<c:url value='/product-edit/${product.id}'></c:url>">Edit</a>
				<a href="<c:url value='/add-cart/${product.id}'></c:url>">Add
					Cart</a></td>
		</tr>
	</c:forEach>

</table>