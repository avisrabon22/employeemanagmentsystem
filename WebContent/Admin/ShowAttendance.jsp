<%@page import="com.employeemanagementsystem.model.AttendanceModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Attendance</title>
<%@ include file="/Allcomp/allcomp.jsp"%>
<%@ include file="/Allcomp/navbar.jsp"%>
</head>
<body>
	<%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if ((request.getSession(false).getAttribute("ADMIN") == null)) {
		response.sendRedirect(request.getContextPath() + "/Welcome.jsp");
	}
	%>

	<h1 class="text-center">Employee Attendance</h1>

	<table class="table border">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Username</th>
				<th>Date</th>
				<th>In Time</th>
				<th>Out Time</th>
				<th>Status</th>
			</tr>
		</thead>
		<%
		List<AttendanceModel> showAttendance = (List<AttendanceModel>) session.getAttribute("");
		%>
		<tbody>
			<tr>
				<td><input type="text" name="ID" value="<%=%>" /></td>
				<td><input type="text" name="Name" value="<%=%>" /></td>
				<td><input type="text" name="Username" value="<%=%>" /></td>
				<td><input type="text" name="Date" value="<%=%>" /></td>
				<td><input type="text" name="Intime" value="<%=%>" /></td>
				<td><input type="text" name="Outtime" value="<%=%>" /></td>
				<td><input type="text" name="Status" value="<%=%>" /></td>



			</tr>
		</tbody>



	</table>























</body>
</html>