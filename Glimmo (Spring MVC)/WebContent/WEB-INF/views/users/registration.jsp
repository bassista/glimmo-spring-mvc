<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div id="registrationPannel">
	<sf:form method="POST" modelAttribute="newUser">
		<table>
			<tr>
				<td><sf:label path="username">Username</sf:label></td>
				<td><sf:input id="username" path="username" /><br />
				<sf:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><sf:label path="email">Email</sf:label></td>
				<td><sf:input id="email" path="email" /><br />
				<sf:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td><sf:label path="firstName">First name</sf:label></td>
				<td><sf:input id="firstname" path="firstName" /><br />
				<sf:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><sf:label path="lastName">Last name</sf:label></td>
				<td><sf:input id="lastname" path="lastName" /><br />
				<sf:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><sf:label path="password">Password</sf:label></td>
				<td><sf:password id="password" path="password" /><br />
				<sf:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><sf:label path="passwordConfirmation">Retype your password</sf:label></td>
				<td><sf:password id="passwordConfirmation" path="passwordConfirmation" /><br />
				<sf:errors path="passwordConfirmation" cssClass="error" /></td>
			</tr>
		</table>
		<input type="submit" value="Create new account">
	</sf:form>
</div>
