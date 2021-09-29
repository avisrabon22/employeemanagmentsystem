<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark Attendance</title>
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
	
	<h1 class="text-center">Select to Mark attendance</h1>
	<div class="text-center">
		<form action="<%=request.getContextPath() %>/UploadAttendanceServlet" method="post">
			<div>
				<select name="Role" id="Role">
					<option>Your choose</option>
					<option value="Users">Users</option>
				</select>
			</div>
			<button type="submit">Submit</button>
		</form>
	</div>
	<%String nullAttend=(String)session.getAttribute("nullattend");
	if(nullAttend!=null){%>
		<p class="text-center text-danger"><%=nullAttend%></p>
	
	<%session.removeAttribute("nullattend");}%>

</body>
</html>