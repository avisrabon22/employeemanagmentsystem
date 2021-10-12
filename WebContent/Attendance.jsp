<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="Allcomp/allcomp.jsp"%>
<%@ include file="Allcomp/navbar.jsp"%>
<title>Attendance</title>
</head>


<body>
	<%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if (request.getSession(false).getAttribute("USER") == null) {
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
	%>


	<h1 class="text-center">Attendance</h1>
	<h2></h2>
<div></div>








</body>
</html>