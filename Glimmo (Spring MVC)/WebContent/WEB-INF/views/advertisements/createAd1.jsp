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
	<div id="form">
		<sf:form method="POST" modelAttribute="newAdvertisement">
			<table>
				<tr>
					<!-- Dropdown menu populated based upon an Enumerated value -->
					<td><sf:label path="adType">Type of good to be advertised</sf:label></td>
					<td>
						<sf:select path="adType">
							<sf:option value="Select a type of good"></sf:option>
							<sf:options />
						</sf:select>
					</td>
				</tr>
				<tr>
					<td><sf:label path="publicationDate">Date to publish</sf:label></td>
					<td><sf:input id="publicationDate" path="publicationDate" /><br />
					<sf:errors path="publicationDate" cssClass="error" /></td>
				</tr>
			</table>
			<input type="submit" name="_eventId_go-to-step2" value="Next">
		</sf:form>
	</div>
</body>
</html>