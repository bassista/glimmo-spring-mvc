<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div id="registrationPannel">
		<sf:form method="POST" modelAttribute="newUser">
			<sf:label path="username">Username</sf:label>
			<sf:input id="username" path="username" />
			
			<sf:label path="email">Email</sf:label>
			<sf:input id="email" path="email"/>
			
			<sf:label path="firstName">First name</sf:label>
			<sf:input id="firstname" path="firstName"/>
			
			<sf:label path="lastName">Last name</sf:label>
			<sf:input id="lastname" path="lastName"/>
			
			<sf:label path="password">Password</sf:label>
			<sf:input id="password" path="password" />

			<input type="submit" value="Create new account">
		</sf:form>
	</div>
</body>
</html>