<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="Allcomp/allcomp.jsp" %>
<%@ include file="Allcomp/navbar.jsp"%>
<title>About Us</title>
</head>


<body>
<%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if (request.getSession(false).getAttribute("USER") == null) {
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
	%>
	
<h1 class="text-center">About Us</h1>
<p class="text-center">"We are PCS Group, Last 15 years we are one of the top BPO in the North India."</p>
</body>
</html>