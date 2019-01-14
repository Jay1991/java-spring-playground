<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" />
		<br />
		Last name: <form:input path="lastName" />
		<br />
		Country:
		<form:select path="country">
			<form:options items="${countryOptions}" />
		</form:select>
		<br />
		Favorite language:<br />
		<form:radiobuttons path="favoriteLanguage" items="${favoriteLanguageOptions}" />
		<br />
		Operating Systems:<br />
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Windows <form:checkbox path="operatingSystems" value="Windows" />
		Mac <form:checkbox path="operatingSystems" value="Mac" />
		<button>Submit</button>
	</form:form>
</body>
</html>