<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
	</div>
	<section id="container">
		<a class="add-button" href="${pageContext.request.contextPath}/customer/new">New Customer</a>
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>E-mail</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td>
								<a href="${pageContext.request.contextPath}/customer/edit?id=${customer.id}">Edit</a>
								&nbsp;|&nbsp;
								<a class="delete"
								   href="${pageContext.request.contextPath}/customer/delete?id=${customer.id}"
								   onclick="if(!confirm('Are you sure?')) return false;">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>