
<!DOCTYPE html>

<html>
	<head>
		<title>Admin Page</title>
		<link type="text/css" rel="stylesheet" href="${pageContect.request.contextPath}/resources/css/style.css">
	</head>
	
	<body>
	
		<div id = "wrapper">
			<div id = "header">
			<h2>Welcome to the Admin Page</h2>
			</div>
		</div>
		
		<div id = "container">
			<div id = "content">
				<table class="tabla">
					<tr>
						<th>Settings</th>
					</tr>
					<tr>
						<td><a href="/users/products"> Manage Products </a></td>
					</tr>
					<tr>
						<td><a href="/users/categories"> Manage Categories </a></td>
					</tr>
					<tr>
						<td><a href="/users/users"> Manage Users </a></td>
					</tr>
				</table>
				
				 
			</div>
		</div>
	
	</body>
</html>