<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Save Categories</title>
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/style.css">
		
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/add-todo-style.css">
	</head>
	
	<body>
	
		<div id = "wrapper">
			<div id = "header">
			<h2>List Categories</h2>
			</div>
		</div>
		
		<div id = "container">
			<h3>Save Category</h3>
			
			<form:form action="saveCategories" modelAttribute="categories" method="post">
				<form:hidden path="categoryID"/>
				
				<table>
					<tbody>
						<tr>
							<td><label>Description: </label></td>
							<td><form:input path="description"/></td>
						</tr>
						<tr>
							<td><label>Date Added: </label></td>
							<fmt:formatDate value="${categories.dateAdded}" var="dates" pattern="dd/MM/yyyy"/>
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
				<a href="${pageContext.request.contextPath}/users/categories">Back to Categories</a>
			</p>
		</div>
		 
	
	</body>
</html>