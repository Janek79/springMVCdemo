<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Adding customer</title>
</head>
<body>
	<form:form modelAttribute="customer" action="process">
		<table>
			<tr>
				<td>First name</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>