<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Home</title>
<style type="text/css">
h1 {
	color: red;
}

h3 {
	color: blue;
}

h2 {
	color: violet;
}
</style>
</head>
<body>
	<div class="container" align="center">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome to Register Page</h2>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="testModel">
					<table>
						<tr>
							<th>FirstName</th>
							<th><form:input path="firstName" required="true" /></th>
						</tr>
						<tr>
							<th>LastName</th>
							<th><form:input path="lastName" required="true" /></th>
						</tr>
						<tr>
							<th>DateOfBirth</th>
							<th><form:input path="dob" type="date" required="true" /></th>
						</tr>
						<tr>
							<th>Email</th>
							<th><form:input path="email" type="email" required="true" /></th>
						</tr>
						<tr>
							<th>MobileNumber</th>
							<th><form:input path="number" required="true" /></th>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="register"></td>
					</table>
				</form:form>
			</div>
			<div class="card-footer bg-info text-white">
				<c:if test="${msg ne null}">${msg} <br>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>