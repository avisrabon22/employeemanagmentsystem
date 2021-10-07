<%@page
	import="com.employeemanagementsystem.model.Admin.AttandanceModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.employeemanagementsystem.model.Admin.SignUpModel"%>
<%@page import="java.util.List"%>
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
	<%
	List<SignUpModel> userofAttandance = (ArrayList<SignUpModel>) session.getAttribute("userofAttandance");
	List<AttandanceModel> UpdatedUserofAttandance = (ArrayList<AttandanceModel>) session
			.getAttribute("UpdatedUserofAttandance");
	String nullAttandance = (String) session.getAttribute("nouserforAttandance");
	if (userofAttandance == null) {
	%>
	<p class="text-center"><%=nullAttandance%></p>
	<%
	} else {
	%>
	<form class="text-center" action="<%=request.getContextPath()%>/UploadAttendanceServlet" method="post">

		<table class="table border">
			<%for(SignUpModel userAttandance : userofAttandance)
			 {
			%>
			<tr>
				<td>ID<input disabled name="ID" type="text"
					value="<%=userAttandance.getID()%>" placeholder="" class="m-1"></td>
				<td>Name<input disabled name="Name" type="text"
					value="<%=userAttandance.getFullName()%>" placeholder=""
					class="m-1"></td>
				<td>In Time<input Name="InTime" type="time"
					value=""
					placeholder="In
				Time" class="m-1">
				</td>
				<td>Out Time<input Name="OutTime" type="time"
					value=""
					placeholder="Out Time" class="m-1"></td>
				<td><input Name="Status" type="text"
					value="" placeholder="Status"></td>
				<td><input type="submit" value="Mark"></td>

			</tr>
			<%}
				}
				
				%>
		</table>
	</form>





</body>
</html>