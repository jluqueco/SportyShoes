<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Save Todos</title>
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/style.css">
		
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/add-todo-style.css">
	</head>
	
	<body>
	
		<div id = "wrapper">
			<div id = "header">
			<h2>List Todos</h2>
			</div>
		</div>
		
		<div id = "container">
			<h3>Save Todo</h3>
			
			<form:form action="saveTodos" modelAttribute="todos" method="post">
				<form:hidden path="id"/>
				
				<table>
					<tbody>
						<tr>
							<td><label>Description: </label></td>
							<td><form:input path="description"/></td>
						</tr>
						
						<tr>
							<td><label>Target Date: </label></td>
							<fmt:formatDate value="${todos.targetDate}" var="dates" pattern="dd/MM/yyyy"/>
							<td><form:input path="targetDate" value="${dates}"/></td>
						</tr>
						<tr>
							<td><label>is Done? </label></td>
							<td><form:input path="isDone"/></td>
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
				<a href="${pageContext.request.contextPath}/users/todos">Back to List</a>
			</p>
		</div>
		 
	
	</body>
</html>