<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#publicationDate").datepicker({
			dateFormat: 'dd/mm/yy' // Belgian date format
		});
		
		$("#deadline").datepicker({
			dateFormat: 'dd/mm/yy' // Belgian date format
		});	
		
 		$("#descriptionsAccordion").accordion({
				collapsible: true,
				active: false,
				autoHeight: false				
		});
	});	
</script>
<div id="form">
	<sf:form method="POST" modelAttribute="newAdvertisement">
		<fieldset id="adInfo">
			<legend>Advertisement configuration</legend>
			<table>
				<tr>
					<!-- Dropdown menu populated based upon an Enumerated value -->
					<td><sf:label path="adType">Type of advertisement</sf:label></td>
					<td><sf:select path="adType">
							<sf:option value="Select a type of advertisement"></sf:option>
							<sf:options />
						</sf:select> <br />
					<sf:errors path="goodType" cssClass="error" /></td>
				</tr>
				<tr>
					<td><sf:label path="publicationDate">Publication date</sf:label></td>
					<td><sf:input id="publicationDate" path="publicationDate" autocomplete="off"/> <br />
					<sf:errors path="publicationDate" cssClass="error" /></td>
				</tr>
				<tr>
					<td><sf:label path="deadline">Expiration date</sf:label></td>
					<td><sf:input id="deadline" path="deadline" autocomplete="off" /> <br />
					<sf:errors path="deadline" cssClass="error" /></td>
				</tr>
				<tr>
					<td><sf:label path="goodType">Type of good</sf:label></td>
					<td><sf:select path="goodType">
							<sf:option value="Select a type of good"></sf:option>
							<sf:options />
						</sf:select> <br />
					<sf:errors path="goodType" cssClass="error" /></td>
				</tr>
			</table>
		</fieldset>

		<fieldset id="descriptionSet">
			<legend>Description of the good</legend>
			<div id="descriptionsAccordion">
				<h3>
					<a href="#">Description (Français)</a>
				</h3>
				<sf:textarea path="descriptionFr" class="fit_textarea" rows="8"/>
				<h3>
					<a href="#">Beschrijving</a>
				</h3>
				<sf:textarea path="descriptionNl" class="fit_textarea" rows="8" />
				<h3>
					<a href="#">Description (English)</a>
				</h3>
				<sf:textarea path="descriptionEn" class="fit_textarea" rows="8" />
			</div>
		</fieldset>
		
		<fieldset id="addressSet">
			<legend>Address</legend>
			<table>
				<tr>
					<td><sf:label path="address.street">Street</sf:label></td>
					<td><sf:input id="street" path="address.street" />
					<td><sf:label path="address.number">Nr.</sf:label></td>
					<td><sf:input id="number" path="address.number" />
				</tr>
				<tr>
					<td><sf:label path="address.zipCode">Zipcode</sf:label></td>
					<td><sf:input id="zipCode" path="address.zipCode"/><br />
					<sf:errors path="address.zipCode" cssClass="error" /></td>
					<td><sf:label path="address.city">City</sf:label></td>
					<td><sf:input id="city" path="address.city"/><br />
					<sf:errors path="address.city" cssClass="error" /></td>				
					<td><sf:label path="address.country">Country</sf:label></td>
					<td><sf:input id="country" path="address.country"/><br />
					<sf:errors path="address.country" cssClass="error" /></td>			
				</tr>
			</table>
		</fieldset>
		<input type="submit" name="_eventId_go-to-next-step" value="Next step">
	</sf:form>
</div>