<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Please log in:
	<form:form action="login" method="post">
		<table>
			<tr>
				<th>Username:</th>
				<th><input type="text" name="username"></th>
			</tr>
			<tr>
				<th>Password:</th>
				<th><input type="password" name="password"></th>
			</tr>
		</table>
		<c:if test="${param.error != null}">
				Such user doesn't exist. Check once again username and password.<br />
		</c:if>

		<input type="submit" value="Log in">
	</form:form>
</body>
</html>