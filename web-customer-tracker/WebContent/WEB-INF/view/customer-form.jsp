<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
		<title>Insert title here</title>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h1>CRM - Customer Relationship Manager</h1>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
				<h3>New Customer</h3>
				<form:form action="${pageContext.request.contextPath}/customer/save" modelAttribute="customer" method="post">
					<form:hidden path="id" />
					<div>
						</div><form:label path="firstName">First Name:</form:label>
						<form:input path="firstName" />
					</div>
					<div>
						<form:label path="lastName">Last Name:</form:label>
						<form:input path="lastName" />
					</div>
					<div>
						<form:label path="email">E-mail:</form:label>
						<form:input path="email" />
					</div>
					<div>
						<label></label>		
						<button class="add-button">Save Customer</button>
					</div>
				</form:form>
			</div>
		</div>
	</body>
</html>