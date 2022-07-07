<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Users</title>
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/style.css">
	</head>
	
	<body>
	
		<div id = "wrapper">
			<div id = "header">
			<h2>List Users</h2>
			</div>
		</div>
		
		<div id = "container">
			<div id = "content">
				<input type="button" value="Add Product" onClick="window.location.href='/users/products/showFormForAdd'; return false;"class="add-button">
				
				<p></p>
				
				<table>
					<tr>
						<th>Username</th>
						<th>Name</th>
						<th>Last Name</th>
						<th>birth date</th>
						<th>Admin</th>
						<th>Password</th>
						<th>Actions</th>
					</tr>
					
					<c:forEach var="tempUser" items="${users}">
						<c:url var="updateLink" value="/users/users/showFormForUpdate">
							<c:param name="userId" value="${tempUser.userID}"/>
						</c:url>
						
						<c:url var="deleteLink" value="/users/users/delete">
							<c:param name="userId" value="${tempUser.userID}"/>
						</c:url>
						
						<tr>
							<td>${tempUser.username}</td>
							<td>${tempUser.name}</td>
							<td>${tempUser.lastName}</td>
							<td><fmt:formatDate type="date" value="${tempUser.birthDate}"/></td>
							<td>${tempUser.admin}</td>
							<td>${tempUser.password}</td>
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