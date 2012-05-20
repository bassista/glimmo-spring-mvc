<%-- <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Glimmo</title>
<link
	href="<c:url value="/resources/css/main_template.css" />" rel="stylesheet" type="text/css"/>
</head>

<body>
	<div id="banner">
		<img alt="home"
			src="<c:url value="/resources/images/Glimmo-test-banner.png" />" />
	</div>

	<%--     <div id="container">
      <a href="<s:url value="/home" />"><img 
          src="<s:url value="/resources" />/images/spitter_logo_50.png" 
          border="0"/></a>
      <div id="top">
        <t:insertAttribute name="top" /> <!--<co id="co_tile_top" />-->
      </div>
      <div id="side">
        <t:insertAttribute name="side" /> <!--<co id="co_tile_side" />-->
      </div>
      <div id="content">
        <t:insertAttribute name="content" /> <!--<co id="co_tile_content" />-->
      </div>
    </div> --%>
</body>
</html>
