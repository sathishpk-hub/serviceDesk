<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<c:if test="${empty ticket.id}">
			<title>Add new Ticket</title>
		</c:if>
		<c:if test="${not empty ticket.id}">
			<title>Edit Ticket</title>
		</c:if>
	</head>
	
	<body>
		<c:if test="${empty ticket.id}">
			<h2>Add New Ticket</h2>
		</c:if>
		
		<c:if test="${not empty ticket.id}">
			<h2>Edit Ticket</h2>
		</c:if>
		
		
		
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
			        <td><form:label path="status">Status:</form:label></td>
                    <td>
                    
                    <c:if test="${empty ticket.id}">
						<form:select path="status">
						   <form:option value="Open" label="Open"/>
						</form:select>
					</c:if>
					<c:if test="${not empty ticket.id}">
						<form:select path="status">
						   <form:option value="Open" label="Open"/>
						   <form:option value="InProgress" label="InProgress"/>
						   <form:option value="Closed" label="Close"/>
						</form:select>
					</c:if>
		
                    </td>
                    
                    <td><form:hidden path="createDateTime" value="${ticket.createDateTime}" readonly="true"/></td>
                    
			    </tr>
			    
			    <tr>
			      <td colspan="2">
				      <input type="submit" value="Submit"/>  &nbsp;
				      <input action="action" type="button" onclick="history.go(-1);" value="Back"/>
			      </td>
		      </tr>
			</table> 
		</form:form>

	</body>
</html>