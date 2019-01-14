<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${student.firstName} ${student.lastName}
<br />
Country: ${student.country}
<br />
Favorite language: ${student.favoriteLanguage}
<br />
Operating systems:
<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
		<li>${temp }</li>
	</c:forEach>
</ul>
</body>
</html>