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

	<div >
		<table class="table table-bordered ">
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
					<th scope="col"></th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>

			</tbody>

		</table>


	</div>



</body>
</html>