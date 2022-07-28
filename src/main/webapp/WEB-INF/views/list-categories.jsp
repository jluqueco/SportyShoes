<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Categories</title>
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/style.css">
	</head>
	
	<body>
	
		<div id = "wrapper">
			<div id = "header">
			<h2>List Categories</h2>
			</div>
		</div>
		
		<div id = "container">
			<div id = "content">
				<input type="button" value="Add Product" onClick="window.location.href='/users/categories/showFormForAdd'; return false;"class="add-button">
				
				<p></p>
				
				<table>
					<tr>
						<th>Categories</th>
						<th>Created</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempCategory" items="${categories}">
						<c:url var="updateLink" value="/users/categories/showFormForUpdate">
							<c:param name="categoryId" value="${tempCategory.categoryID}"/>
						</c:url>
						
						<c:url var="deleteLink" value="/users/categories/delete">
							<c:param name="categoriesId" value="${tempCategory.categoryID}"/>
						</c:url>
						
						<tr>
							<td>${tempCategory.description}</td>
							<td><fmt:formatDate type="date" value="${tempCategory.dateAdded}"/></td>
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