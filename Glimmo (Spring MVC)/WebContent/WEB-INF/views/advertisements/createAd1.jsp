<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div id="form">
	<sf:form method="POST" modelAttribute="newAdvertisement">
		<fieldset id="adInfo">
			<legend>Advertisement:</legend>
			<table>
				<tr>
					<!-- Dropdown menu populated based upon an Enumerated value -->
					<td><sf:label path="adType">Type of advertisement</sf:label></td>
					<td><sf:select path="adType">
							<sf:option value="Select a type of advertisement"></sf:option>
							<sf:options />
						</sf:select></td>
				</tr>
				<tr>
					<td><sf:label path="publicationDate">Date to publish</sf:label></td>
					<td><sf:input id="publicationDate" path="publicationDate" /><br /> <sf:errors path="publicationDate" cssClass="error" /></td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" name="_eventId_go-to-step2" value="Next">
	</sf:form>
</div>
