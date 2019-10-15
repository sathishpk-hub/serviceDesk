<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>All Tickets</title>
</head>
<body>
<h1>List Tickets</h1>
<h3>
	<a href="/serviceDesk/add">Add New Ticket</a>
</h3>

<c:if test="${!empty listTickets}">
		<h2>List Tickets</h2>
		<table align="left" border="1">
		<tr>
			<th>Ticket ID</th>
			<th>Title/Name</th>
			<th>Email</th>
			<th>Problem Description</th>
			<th>Priority(SLA))</th>
		</tr>

		<c:forEach items="${listTickets}" var="ticket">
			<tr>
				<td><c:out value="${ticket.id}"/></td>
				<td><c:out value="${ticket.name}"/></td>
				<td><c:out value="${ticket.email}"/></td>
				<td><c:out value="${ticket.pbmDesc}"/></td>
				<td><c:out value="${ticket.priority}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>