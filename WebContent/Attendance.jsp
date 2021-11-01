<%@page import="com.employeemanagementsystem.model.AttendanceModel"%>
<%@page import="java.util.List"%>
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
	<!--*******************************************************************************************************************  -->
	<%
	List<AttendanceModel> attendance = (List<AttendanceModel>) session.getAttribute("userAttendance");
	%>
	<h1 class="text-center">Attendance</h1>

	<%
	if (attendance != null) {
	%>
	<table class="table border">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>In Time</th>
				<th>Out Time</th>
				<th>Status</th>

			</tr>
		</thead>
		<tbody>
			<%
			for (AttendanceModel userattendance : attendance) {
			%>
			<tr>
				<td><%=userattendance.getName()%></td>
				<td><%=userattendance.getDate()%></td>
				<td><%=userattendance.getIntime()%></td>
				<td><%=userattendance.getOuttime()%></td>
				<td><%=userattendance.getStatus()%></td>
			</tr>

			<%
			}
			}
			%>
		</tbody>
	</table>


	<div></div>








</body>
</html>