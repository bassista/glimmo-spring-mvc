<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#surfaceSlider").slider({
			value:0,
			min: 0,
			max: 1000,
			step: 1,
			slide: function( event, ui ) {
				$("#groundSurface").val(ui.value);
			}
		});
		
		$("#groundSurface").val(0);
		
		$("#groundSurface").bind("paste keydown input", updateSlider);
	});	
		
	function updateSlider() {
		$("#surfaceSlider").slider("value", $("#groundSurface").val());			
	}
</script>
<div id="form">
	<sf:form method="POST" modelAttribute="landDescription">
		<fieldset id="landDescription">
			<legend>Land description</legend>
			<table>
				<tr>
					<td>
						<sf:label path="groundSurface">Area (m²)</sf:label>
						<sf:input id="groundSurface" path="groundSurface" autocomplete="off"/>
						<div id="surfaceSlider"></div>
					</td>
				</tr>
				<tr>
					<td>
						<sf:label path="price">Price</sf:label>
						<sf:input id="price" path="price" autocomplete="off" />
					</td>
					<td>
						<sf:label path="licenceToBuild">License to build</sf:label>
						<sf:checkbox id="licenceToBuild" path="licenceToBuild"  />
					</td>
				</tr>				
			</table>
		</fieldset>
		<input type="submit" name="_eventId_go-to-previous-step" value="Previous step" />
		<input type="submit" name="_eventId_finish" value="Finish" />
	</sf:form>
</div>