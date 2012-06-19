<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div id="loginPannel">
		<sf:form action="login.do" method="POST" modelAttribute="loginUser">
			<table>
				<tr>
					<td><sf:label path="username">Username</sf:label></td>
					<td><sf:input id="username" path="username" /></td>
				</tr>
				<tr>
					<td><sf:label path="password">Password</sf:label></td>
					<td><sf:password id="password" path="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Sign in">
		</sf:form>
		<a href="<s:url value="/register.do" />"> Register</a>
	</div>
</body>
</html>