<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<s:url value="/resources/"/>css/registration.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="registrationPannel">
		<sf:form method="POST" modelAttribute="newUser">
			<table>
				<tr>
					<td><sf:label path="username">Username</sf:label></td>
					<td><sf:input id="username" path="username" /></td>
				</tr>
				<tr>
					<td><sf:label path="email">Email</sf:label></td>
					<td><sf:input id="email" path="email" /></td>
				</tr>
				<tr>
					<td><sf:label path="firstName">First name</sf:label></td>
					<td><sf:input id="firstname" path="firstName" /></td>
				</tr>
				<tr>
					<td><sf:label path="lastName">Last name</sf:label></td>
					<td><sf:input id="lastname" path="lastName" /></td>
				</tr>
				<tr>
					<td><sf:label path="password">Password</sf:label></td>
					<td><sf:input id="password" path="password" /></td>
				</tr>
				<tr>
					<td><sf:label path="passwordConfirmation">Retype your password</sf:label></td>
					<td><sf:input id="passwordConfirmation" path="passwordConfirmation" /></td>
				</tr>
			</table>
			<input type="submit" value="Create new account">
		</sf:form>
	</div>
</body>
</html>