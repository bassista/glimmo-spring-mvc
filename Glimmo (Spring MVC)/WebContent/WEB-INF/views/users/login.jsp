<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div id="loginPannel">
	<security:authorize access="!isAuthenticated()">
		<c:if test="${errorOccurred}">
			<div class="loginError">Could not sign in, please check your login/password...</div>
		</c:if>

		<form method="post" class="signin" action="j_spring_security_check">
			<table cellspacing="0">
				<tr>
					<th><label for="username_or_email">Username/email</label></th>
					<td><input id="username_or_email" name="j_username" type="text" /></td>
				</tr>
				<tr>
					<th><label for="password">Password</label></th>
					<td><input id="password" name="j_password" type="password" /> <small><a href="/account/resend_password">Forgot?</a></small></td>
				</tr>
				<tr>
					<th></th>
					<td><input id="remember_me" name="_spring_security_remember_me" type="checkbox" /> <label for="remember_me" class="inline">Remember
							me</label></td>
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
			Welcome, <security:authentication property="principal.username" />
		<a href="<s:url value="j_spring_security_logout" /> ">Sign out</a>
	</security:authorize>
</div>
