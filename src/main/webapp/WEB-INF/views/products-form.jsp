<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Products</title>
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/style.css">
		
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/add-todo-style.css">
	</head>
	
	<body>
	
		<div id = "wrapper">
			<div id = "header">
			<h2>Save Product</h2>
			</div>
		</div>
		
		<div id = "container">
			<h3>Save Product</h3>
			
			<form:form action="saveProducts" modelAttribute="products" method="post">
				<form:hidden path="ID"/>
				
				<table>
					<tbody>
						<tr>
							<td><label>Name: </label></td>
							<td><form:input path="name"/></td>
						</tr>
						<tr>
							<td><label>Price: </label></td>
							<td><form:input path="price"/></td>
						</tr>
						<tr>
							<td><label>Category: </label></td>
							<td><form:input path="category"/></td>
						</tr>
						<tr>
							<td><label>Date Added: </label></td>
							<fmt:formatDate value="${products.dateAdded}" var="dates" pattern="dd/MM/yyyy"/>
							<td><form:input path="dateAdded" value="${dates}"/></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="2"><input type="submit" value="save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/users/products">Back to List</a>
			</p>
		</div>
		 
	
	</body>
</html>