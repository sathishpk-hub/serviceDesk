<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service Desk application</title>
</head>
<body>
<div align="center">
	<h2>Service Desk application (Tickets List)</h2>
	<form method="get" action="search">
		<input type="text" name="keyword" /> &nbsp;
		<input type="submit" value="Search" />
	</form>
	<h3><a href="add">Add New Ticket</a></h3>
	<table border="1" cellpadding="5">
		<tr>
			<th>Ticket No</th>
			<th>Name</th>
			<th>E-mail</th>
			<th>Problem Description</th>
			<th>Priority(SLA)</th>
			<th>Status</th>
			<th>Created Date</th>
			<th>Last Modified Date</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${listTickets}" var="ticket">
			<c:if test="${ticket.status ne 'Closed'}">
				<tr>
					<td>${ticket.id}</td>
					<td>${ticket.name}</td>
					<td>${ticket.email}</td>
					<td>${ticket.pbmDesc}</td>
					<td>${ticket.priority}</td>
					<td>${ticket.status}</td>
					<td><fmt:formatDate value="${ticket.createDateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${ticket.updateDateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<a href="edit?id=${ticket.id}">Edit</a>
						&nbsp;&nbsp;| &nbsp;
						<a href="delete?id=${ticket.id}" onclick = "javascript: return false;" style="cursor: default; color: gray;">Delete</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</div>	
</body>
</html>