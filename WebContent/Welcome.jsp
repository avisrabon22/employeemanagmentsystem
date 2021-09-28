<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/Allcomp/allcomp.jsp"%>
<title>Welcome</title>
</head>


<body>
	<%
	if (request.getSession(false).getAttribute("USER") != null) {
		response.sendRedirect("Dashboard.jsp");
	}

	else if (request.getSession(false).getAttribute("ADMIN") != null) {
		response.sendRedirect("Admin/Admindashboard.jsp");
	}
	%>

	<!-- ****************************************************************************************** -->
	<h1 class="text-center">Welcome to Employee Management Portal</h1>
	<div class="d-flex justify-content-center">
		<form action="Login.jsp">
			<input class="btn btn-outline-primary" type="submit" value="Login">
		</form>
	</div>
</body>
</html>