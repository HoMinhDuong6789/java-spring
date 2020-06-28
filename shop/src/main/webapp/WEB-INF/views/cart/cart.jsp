<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<p>List Item Order</p>
<hr />

<table>
	<tr>
		<th>Name</th>
		<th>Price</th>
		<th>Number</th>
		<th>Choose</th>
	</tr>


	<c:forEach items="${order.itemDTOs}" var="item">
		<tr>
			<td>${item.productDTO.name}</td>
			<td>${item.productDTO.price}</td>
			<td>${item.number}</td>
			<!--19.16  -->
			<td><a
				href="<c:url value='/delete-cart/${item.productDTO.id}'></c:url>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>