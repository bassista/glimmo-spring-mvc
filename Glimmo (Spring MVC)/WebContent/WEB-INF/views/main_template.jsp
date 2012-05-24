<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<html lang="ENG">
<head>
<title>Glimmo</title>
	<link href="<s:url value="/resources/"/>css/main_template.css" rel="stylesheet" type="text/css" />
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
</body>
</html>
