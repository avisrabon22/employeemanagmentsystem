<%@page import="com.employeemanagementsystem.model.Admin.AttandanceAdminModel"%>
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
		List<AttandanceAdminModel> showAttendance = (List<AttandanceAdminModel>) session.getAttribute("showAttendace");
		if(showAttendance!=null){
		%>
		<tbody>
		<% for(AttandanceAdminModel showAttend:showAttendance){%>
			<tr>
				<td><input type="text" name="ID" value="<%=showAttend.getID()%>" readonly /></td>
				<td><input type="text" name="Name" value="<%=showAttend.getName()%>" readonly /></td>
				<td><input type="text" name="Username" value="<%=showAttend.getUsername()%>" readonly /></td>
				<td><input type="text" name="Date" value="<%=showAttend.getDate()%>" readonly/></td>
				<td><input type="text" name="Intime" value="<%=showAttend.getInTime()%>" readonly/></td>
				<td><input type="text" name="Outtime" value="<%=showAttend.getOutTime()%>" readonly/></td>
				<td><input type="text" name="Status" value="<%=showAttend.getStatus()%>" readonly/></td>

			</tr>
			<%}} %>
		</tbody>



	</table>























</body>
</html>