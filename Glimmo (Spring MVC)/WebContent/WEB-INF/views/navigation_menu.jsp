<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<s:url value="/resources/"/>css/navigation.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- the following menu navigation bar has been downloaded from the internet... -->
	<div class='cssmenu'>
		<ul>
			<li class='active '><a href='home.do'><span>Home</span></a></li>
			<li><a href='search.do'><span>Search a good</span></a></li>
			<li><a href='createAd.do'><span>Post an advertisement</span></a></li>

			<security:authorize access="hasRole('ADMIN')">
				<li><a href='admin.do'><span>Administration corner</span></a></li>
			</security:authorize>
		</ul>
	</div>
</body>
</html>