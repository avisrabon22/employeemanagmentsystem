<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
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


	<h1 class="text-center">Welcome Admin</h1>
	<div class="m-2">
		<div class="m-2">
			<a
				href="http://localhost:8080/employeemanagementsystem/Admin/Signup.jsp"
				class="">Add User</a>
		</div>
	</div>
	<!-- <div class="m-2"><a href="http://localhost:8080/employeemanagementsystem/Admin/UserList.jsp">User List</a></div> -->
	<div>
		<div class="m-2">
			<a href="<%=request.getContextPath()%>/UserListServlet" class="">Users</a>
		</div>

		<div class="m-2">
			<a
				href="http://localhost:8080/employeemanagementsystem/Admin/UploadReport.jsp"
				class="">Upload Report</a>
		</div>
		
		<div class="m-2">
			<a
				href="<%=request.getContextPath()%>/MainAttendanceServlet"
				class="">Attendance</a>
		</div>

	</div>
	
	
	
</body>
</html>