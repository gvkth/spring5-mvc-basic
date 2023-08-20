<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h1>List customers</h1>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		
	</div>
	<div id="container">
		<div id="content">
			<!-- put new button: Add customer -->
			<input type="button" value="Add Customer" 
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
			/>
			<!-- add out html table here -->
			<table>
				<tr>
					<th>Tên</th>
					<th>Họ</th>
					<th>Thư điện tử</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers }">
					<tr>
					<c:url var="updateLink" value="/customer/showFormForUpdate" >
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>