<%@page import="com.employeemanagementsystem.model.Admin.SignUpModel"%>
<%@page
	import="com.employeemanagementsystem.model.Admin.AttandanceModel"%>
<%@page import="java.util.*"%>
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

	<h1 class="text-center">Mark attendance</h1>


	<div class="text-center">
		<%
	List<SignUpModel> userofAttandance = (List<SignUpModel>) session.getAttribute("userofAttandance");
	/* String nullAttandance = (String) session.getAttribute("nullattend"); */
	if(userofAttandance!=null){		
	for (SignUpModel userAttandance : userofAttandance) {
			%>
		<form class="text-center"
			action="<%=request.getContextPath()%>/MainAttendanceServlet"
			method="post">


			<div class="mb-1">
				ID<input readonly name="ID" type="text"
					value="<%=userAttandance.getID()%>" placeholder="" class="m-1">
			</div>
			<div class="mb-1">
				Name<input readonly name="Name" type="text"
					value="<%=userAttandance.getFullName()%>" placeholder=""
					class="m-1">
			</div>
			<div class="mb-1">
				Name<input readonly name="Username" type="text"
					value="<%=userAttandance.getUsername()%>" placeholder=""
					class="m-1">
			</div>
			
			<div class="mb-1">
				Date<input name="Date" type="text" placeholder="Date"
					class="m-1">
			</div>
 			
 			<div class="mb-1">
				In Time<input name="InTime" type="text" placeholder="In Time"
					class="m-1">
			</div>
			<div class="mb-1">
				Out Time<input name="OutTime" type="text" placeholder="Out Time"
					class="m-1">
			</div>
			<div class="mb-1">
				<input name="Status" type="text" placeholder="Status">
			</div> 


	
			<input type="submit" value="Mark">
		</form>
		<%
			}}
			%>
	</div>
</body>
</html>