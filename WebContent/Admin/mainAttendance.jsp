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
	<% %>
	<form class="text-center" action="" method="post">
		<div class="text-center">
			<span><input name="ID" type="text" value="" placeholder=""></span>
			<span><input name="Name" type="text" value=""
				placeholder=""></span> <span><input Name="InTime"
				type="text" placeholder="In Time"></span> <span><input
				Name="OutTime" type="text" placeholder="Out Time"></span> <span><input
				Name="Status" type="text" placeholder="Status"></span> <input
				type="submit" value="Mark">
		</div>

	</form>





</body>
</html>