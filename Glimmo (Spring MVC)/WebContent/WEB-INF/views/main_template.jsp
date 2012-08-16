<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="ENG">
<head>

<!-- Spring URL variable -->
<s:url value="/resources/css" var="urlVarCss" />
<s:url value="/resources/js/jquery" var="urlVarJQuery" />

<link href="${urlVarCss}/main_template.css" rel="stylesheet" type="text/css" />
<link href="${urlVarCss}/navigation.css" rel="stylesheet" type="text/css" />
<link href="${urlVarCss}/content.css" rel="stylesheet" type="text/css"/>
<link href="${urlVarCss}/registration.css" rel="stylesheet" type="text/css" />
<link href="${urlVarCss}/advertisement_creation.css" rel="stylesheet" type="text/css" />
<link href="${urlVarCss}/jquery-ui-1.8.22.custom.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${urlVarJQuery}/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${urlVarJQuery}/jquery-ui-1.8.22.custom.min.js"></script>


<title>Glimmo</title>
</head>

<body>
	<div id="banner">
		<a id="link_home" href="<s:url value="/home.do" />"> 
			<img id="site_banner" alt="banner" src="<s:url value="resources" />/images/Glimmo-test-banner.png" /> 
		</a>
	</div>

	<div id="navigationMenu">
		<t:insertAttribute name="top" />
	</div>

	<div id="bodyContent">
		<t:insertAttribute name="center" />
	</div>
	
	<div id="right">
		<t:insertAttribute name="right" />
	</div>
</body>
</html>
