<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Products</title>
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/style.css">
	</head>
	
	<body>
	
		<div id = "wrapper">
			<div id = "header">
			<h2>List Products</h2>
			</div>
		</div>
		
		<div id = "container">
			<div id = "content">
				<input type="button" value="Add Product" onClick="window.location.href='/users/products/showFormForAdd'; return false;"class="add-button">
				
				<p></p>
				
				<table>
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Date Created</th>
						<th>Category</th>
						<th>Actions</th>
					</tr>
					
					<c:forEach var="tempProduct" items="${products}">
						<c:url var="updateLink" value="/users/products/showFormForUpdate">
							<c:param name="productId" value="${tempProduct.ID}"/>
						</c:url>
						
						<c:url var="deleteLink" value="/users/todos/delete">
							<c:param name="productId" value="${tempProduct.ID}"/>
						</c:url>
						
						<tr>
							<td>${tempProduct.name}</td>
							<td>${tempProduct.price}</td>
							<td><fmt:formatDate type="date" value="${tempProduct.dateAdded}"/></td>
							<td>${tempProduct.category.description}</td>
							<td>
								<a href="${updateLink}">Update</a>  | 
								<a href="${deleteLink}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<p></p>
				<a href="/index.jsp"> &lt;&lt; Home</a>
			</div>
		</div>
	
	</body>
</html>