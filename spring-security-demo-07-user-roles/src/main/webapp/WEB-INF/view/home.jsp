<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Hello!</h1>
	<p>
		User: <security:authentication property="principal.username" />
		<br />
		Roles: <security:authentication property="principal.authorities" />
	</p>
	<hr />
	<security:authorize access="hasRole('MANAGER')">	
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">I.T Systems Meeting</a>
		</p>	
	</security:authorize>
	<form:form method="post" action="${pageContext.request.contextPath}/logout">
		<button>Logout</button>
	</form:form>
</body>
</html>