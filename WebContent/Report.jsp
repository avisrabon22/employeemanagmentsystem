<%@page import="com.employeemanagementsystem.model.ReportModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Report</title>
<%@ include file="Allcomp/allcomp.jsp"%>
<%@ include file="Allcomp/navbar.jsp"%>
</head>


<body>
	<%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if (request.getSession(false).getAttribute("USER") == null) {
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
	%>


	<h1 class="text-center">REPORT</h1>
	<%
	List<ReportModel> userReport = (List<ReportModel>) session.getAttribute("userReport");
	%>
	<div>
		<table class="table table-bordered ">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Date</th>
					<th scope="col">In Time</th>
					<th scope="col">Out Time</th>
					<th scope="col">Working Time</th>
				</tr>
			</thead>

			<tbody>
				<%
				if (userReport != null) {
					for (ReportModel usersReport : userReport) {
				%>
				<tr>
					<td><%=usersReport.getId()%></td>
					<td><%=usersReport.getName()%></td>
					<td><%=usersReport.getDate()%></td>
					<td><%=usersReport.getInTime()%></td>
					<td><%=usersReport.getOutTime()%></td>
					<td><%=usersReport.getStatus()%></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>

		</table>


	</div>



</body>
</html>