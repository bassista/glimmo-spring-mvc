<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div id="loginPannel">
		<security:authorize access="!isAuthenticated()">
			<form method="post" class="signin" action="j_spring_security_check">
					<table cellspacing="0">
						<tr>
							<th><label for="username_or_email">Username/email</label></th>
							<td><input id="username_or_email" name="j_username" type="text" /></td>
						</tr>
						<tr>
							<th><label for="password">Password</label></th>
							<td><input id="password" name="j_password" type="password" />
								<small><a href="/account/resend_password">Forgot?</a></small></td>
						</tr>
						<tr>
							<th></th>
							<td><input id="remember_me"
								name="_spring_security_remember_me" type="checkbox" /> <label
								for="remember_me" class="inline">Remember me</label></td>
						</tr>
						<tr>
							<th></th>
							<td><input name="commit" type="submit" value="Sign In" /></td>
						</tr>
					</table>
			</form>
			<a href="<s:url value="/register.do" />">Register</a>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			Welcome, <security:authentication property="principal.username"/>
			<a href="<s:url value="j_spring_security_logout" /> ">Sign out</a>
		</security:authorize>
	</div>
</body>
</html>