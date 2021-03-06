<%@page import="org.springframework.security.core.GrantedAuthority"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>

<c:url value="/DataTables-1.9.4/examples/test/" var="homeUrl" />
<c:url value="indexLogin.jsp?id=1" var="userUrl" />
<c:url value="admin" var="adminUrl" />
<c:url value="logout" var="logoutUrl" />

<div class="menu">
	<ul>
		<li><a href="${homeUrl}">Home</a></li>
		<li><a href="${userUrl}">User</a></li>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="${adminUrl}">Admin</a></li>
		</sec:authorize>

		<li><a href="${logoutUrl}">Logout</a></li>
	</ul>
	<span id="menu-username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>
	<br> <span id="menu-roles"> <%
		List<GrantedAuthority> listRole = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority g : listRole) {
			%>Role = <%=g.getAuthority()%><br>
		<%
		}
		%>
	</span> <br style="clear: left" />
</div>