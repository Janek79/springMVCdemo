<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Adding customer</title>
</head>

<body>
<h2>Create new customer</h2>
	<form:form modelAttribute="customer" action="process">
		<table>
			<tr>
				<td>First name</td>
				<td><form:input path="firstName"/></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="lastName"/></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form:form>
	<br/>
	<input type="button" value="Back" onclick="location.href='list'"/>
</body>
</html>