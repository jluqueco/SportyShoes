<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Save Users</title>
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/style.css">
		
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/add-todo-style.css">
	</head>
	
	<body>
	
		<div id = "wrapper">
			<div id = "header">
			<h2>List Users</h2>
			</div>
		</div>
		
		<div id = "container">
			<h3>Save User</h3>
			
			<form:form action="saveUsers" modelAttribute="users" method="post">
				<form:hidden path="userID"/>
				
				<table>
					<tbody>
						<tr>
							<td><label>Username: </label></td>
							<td><form:input path="username"/></td>
						</tr>
						<tr>
							<td><label>Name: </label></td>
							<td><form:input path="name"/></td>
						</tr>
						<tr>
							<td><label>Last Name: </label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						<tr>
							<td><label>Birth Date: </label></td>
							<fmt:formatDate value="${users.birthDate}" var="dates" pattern="dd/MM/yyyy"/>
							<td><form:input path="birthDate" value="${dates}"/></td>
						</tr>
						<tr>
							<td><label>Admin</label></td>
							<td><form:input path="admin"/></td>
						</tr>
						<tr>
							<td><label>Password: </label></td>
							<td><form:input path="password"/></td>
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