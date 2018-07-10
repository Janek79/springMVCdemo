<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Customers list</title>
</head>
<body>
	<table>
		Customers list
		<th>First name</th>
		<th>Last name</th>
		<th>E-mail</th>
		<c:forEach var="customer" items="${customersList}">
			<tr>
				<td><c:out value="${customer.firstName}" /></td>

				<td><c:out value="${customer.lastName}" /></td>

				<td><c:out value="${customer.email}" /></td>
				
				<td><a href="">Update</a></td>
				
				<td><a href="list">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="Add customer to the list" onclick="location.href='form'" />
</body>
</html>