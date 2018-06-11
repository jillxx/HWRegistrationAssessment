<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered User Report</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<style>
h1 {
	color: #00ace6;
}

.table {
	padding: 10px 20px;
	background-color: #ccf2ff;
}

.thead {
	background-color: #3399ff
}
</style>
</head>
<body>
	<div class="container">
		<h1>Registered User Report</h1>
		<table class="table" border="1">
			<thead class="thead">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address1</th>
					<th>Address2</th>
					<th>City</th>
					<th>State</th>
					<th>Zipcode</th>
					<th>Country</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="userinfo" items="${report}">
					<tr>
						<td>${userinfo.firstname}</td>
						<td>${userinfo.lastname}</td>
						<td>${userinfo.address1}</td>
						<td>${userinfo.address2}</td>
						<td>${userinfo.city}</td>
						<td>${userinfo.state}</td>
						<td>${userinfo.zip}</td>
						<td>${userinfo.country}</td>
						<td>${userinfo.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>