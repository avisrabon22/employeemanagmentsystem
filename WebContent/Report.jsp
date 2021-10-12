<%@page
	import="com.employeemanagementsystem.model.Admin.ShowReportModel"%>
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
	List<ShowReportModel> userReport = (List<ShowReportModel>) session.getAttribute("userReport");
	%>
	<div>
		<table class="table table-bordered ">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Designation</th>
					<th scope="col">Salary</th>
				</tr>
			</thead>

			<tbody>
				<%
				for (ShowReportModel usersReport : userReport) {
				%>
				<tr>
					<td><%=usersReport.getID()%></td>


					<td><%=usersReport.getName()%></td>


					<td><%=usersReport.getDesignation()%></td>

					<td><%=usersReport.getSalary()%></td>
				</tr>
				<%
				}
				%>
			</tbody>

		</table>


	</div>



</body>
</html>