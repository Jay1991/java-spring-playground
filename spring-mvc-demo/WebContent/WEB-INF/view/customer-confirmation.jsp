<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	The customer is confirmed:<br />
	First name: ${customer.firstName}<br />
	Last name: ${customer.lastName}<br />
	Free passes: ${customer.freePasses}<br />
	Postal code: ${customer.postalCode}<br />
	Course code: ${customer.courseCode}
</body>
</html>