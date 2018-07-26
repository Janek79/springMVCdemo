<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title>Customers list</title>
</head>
<body>
	<h2>Customers list</h2>

	Search customer:
	<form action="search">
		<input type="text" name="searchedCustomer" /> <input type="submit"
			value="Find" />
	</form>
	<c:if test="${not empty customersList}">
		<table>
			<th>First name</th>
			<th>Last name</th>
			<th>E-mail</th>
			<c:forEach var="customer" items="${customersList}">
				<tr>
					<td><c:out value="${customer.firstName}" /></td>

					<td><c:out value="${customer.lastName}" /></td>

					<td><c:out value="${customer.email}" /></td>


					<security:authorize access="hasRole('ADMIN')">
						<c:url var="updateURL" value="/update">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<td><a href="<c:out value="${updateURL}"/>">Update</a></td>

						<c:url var="deleteURL" value="/delete">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<td><a href="<c:out value="${deleteURL}"/>"
							onclick="return confirm('Are you sure you want to delete that customer?')">Delete</a></td>
					</security:authorize>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty customersList}">
		<h3>Nothing was found</h3>
	</c:if>

	<security:authorize access="hasRole('ADMIN')">
		<input type="button" value="Add customer to the list"
			onclick="location.href='form'" />
	</security:authorize>

	<input type="button" value="Whole list" onclick="location.href='list'" />
	<br />
	<br />
	<input type="button" value="Log out" onclick="location.href='logout'" />
</body>
</html>