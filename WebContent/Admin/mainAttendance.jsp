<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attendance</title>
<%@ include file="/Allcomp/allcomp.jsp"%>
<%@ include file="/Allcomp/navbar.jsp"%>
</head>
<body>
<%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if ((request.getSession(false).getAttribute("ADMIN") == null)) {
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}
	%>
	
	<h1 class="text-center">Attendance</h1>
	
	<div class="text-center">
	<table class="table border">
	<thead>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>In Time</th>
	<th>Out Time</th>
	<th>Working Time</th>
	<th>Status</th>
	</tr>
	</thead>
	
	<tbody>
	<tr><td>1</td></tr>
	</tbody>
	
	
	</table>
	
	
	</div>
	
	
	
	
</body>
</html>