<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<%@ include file="/Allcomp/allcomp.jsp"%>
<%@ include file="/Allcomp/navbar.jsp"%>
<title>Employee Dashboard</title>
</head>

<body>
	<%
	/*response.setHeader("Refresh", "2; URL=Welcome.jsp");  */
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if ((request.getSession(false).getAttribute("USER") == null)) {
		response.sendRedirect("Welcome.jsp");
	}
	%>



	<h1 class="text-center">Welcome to Dashboard</h1>


	<div class="m-1">
		<a href="<%=request.getContextPath()%>/ReportServlet">Reports</a>
	</div>

	<div class="m-1">
		<a href="<%=request.getContextPath()%>/AttendanceServlet">Attendance</a>
	</div>

	<div class="m-1">
		<a href="<%=request.getContextPath()%>/ProfileServlet">Profile</a>
	</div>

	<div class="m-1">
		<a href="<%=request.getContextPath()%>/AboutServlet">About
			us</a>
	</div>



</body>
</html>