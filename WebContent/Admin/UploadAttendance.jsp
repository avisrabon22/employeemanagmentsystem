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

	<h1 class="text-center">Select to Mark attendance</h1>


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


			<div>
				ID<input disabled name="ID" type="text"
					value="<%=userAttandance.getID()%>" placeholder="" class="m-1">
			</div>
			<div>
				Name<input disabled name="Name" type="text"
					value="<%=userAttandance.getFullName()%>" placeholder=""
					class="m-1">
			</div>
 			
 			<div>
				In Time<input Name="InTime" type="time" placeholder="In
				Time"
					class="m-1">
			</div>
			<div>
				Out Time<input Name="OutTime" type="time" placeholder="Out Time"
					class="m-1">
			</div>
			<div>
				<input Name="Status" type="text" placeholder="Status">
			</div> 
			<input type="submit" value="Mark">
		</form>
		<%
			}}
			%>
	</div>
</body>
</html>