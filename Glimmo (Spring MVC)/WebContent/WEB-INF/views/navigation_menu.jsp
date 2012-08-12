<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!-- the following menu navigation bar has been downloaded from the internet... -->
<div class='cssmenu'>
	<ul>
		<li class='active '><a href='home.do'><span>Home</span></a></li>
		<li><a href='search.do'><span>Search a good</span></a></li>

		<security:authorize access="isAuthenticated()">
			<li><a href='createAd.do'><span>Post an advertisement</span></a></li>
		</security:authorize>

		<security:authorize access="hasRole('ADMIN')">
			<li><a href='admin.do'><span>Administration corner</span></a></li>
		</security:authorize>
	</ul>
</div>