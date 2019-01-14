<!DOCTYPE html>
<html>
	<head>
		<title>Spring MVC Demo Home</title>
	</head>
	<body>
		<h1>It Works!</h1>
		<img src="${pageContext.request.contextPath}/resources/img/andre.jpg" />
		<br />
		<a href="hello/showForm">Hello Form</a><br />
		<a href="student/showForm">Student Form</a><br />
		<a href="customer/showForm">Customer Form</a>
	</body>
</html>