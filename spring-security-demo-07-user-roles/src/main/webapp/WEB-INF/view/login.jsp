<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>My Custom Login Page</h3>
	<form:form action="${pageContext.request.contextPath}/doLogin" method="post">
		<!-- check for login error -->
		<c:if test="${param.error != null}">
			<i>Bad Credentials!!!</i>
		</c:if>
		<div>
			<label for="username">User:</label>
			<input type="text" name="username" id="username" />
		</div>
		<div>
			<label for="password">Password:</label>
			<input type="text" name="password" id="password" />
		</div>
		<div>
			<button>Login</button>
		</div>
	</form:form>
</body>
</html>