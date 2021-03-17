<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h2>Users</h2>

	<table style="float: left">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="count">
			<tr id="${count.index}">
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="/users" method="post">
	
	<br><br><br><br><br><br><br><br><br><br>
		<label for="id">ID:</label> <input type="text" id="id" name="id"><br>
		<br>

		<input type="submit" value="Enter">
	</form>



</body>
</html>

