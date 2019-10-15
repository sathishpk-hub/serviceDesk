<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add new Ticket</title>
	</head>
	<body>
		<h2>Add New Ticket</h2>
		<form:form method="POST" action="/serviceDesk/save">
	   		<table>
	   		
				<tr>
		           <td>
		           	<c:if test="${not empty ticket.id}">
					   <form:label path="id">Ticket ID:</form:label>
					</c:if>
		          
		           <td><form:hidden path="id" value="${ticket.id}" readonly="true"/></td>
		       	</tr>
       
			    <tr>
			        <td><form:label path="name">Title/Name:</form:label></td>
			        <td><form:input path="name" value="${ticket.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="email">Email:</form:label></td>
			        <td><form:input path="email" value="${ticket.email}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="pbmDesc">Problem Description:</form:label></td>
			        <td><form:input path="pbmDesc" value="${ticket.pbmDesc}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="priority">Priority(SLA):</form:label></td>
                    <td><form:input path="priority" value="${ticket.priority}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>

  <c:if test="${!empty listTickets}">
		<h2>List Tickets</h2>
		<table align="left" border="1">
		<tr>
			<th>Ticket ID</th>
			<th>Title/Name</th>
			<th>Email</th>
			<th>Problem Description</th>
			<th>Priority(SLA))</th>
			<th>Actions</th>
		</tr>

		<c:forEach items="${listTickets}" var="ticket">
			<tr>
				<td><c:out value="${ticket.id}"/></td>
				<td><c:out value="${ticket.name}"/></td>
				<td><c:out value="${ticket.email}"/></td>
				<td><c:out value="${ticket.pbmDesc}"/></td>
				<td><c:out value="${ticket.priority}"/></td>
				<td align="center">
					<a href="/serviceDesk/edit?id=${ticket.id}">Edit</a> | 
					<a href="/serviceDesk/delete?id=${ticket.id}">Delete</a>
				</td>
				
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>