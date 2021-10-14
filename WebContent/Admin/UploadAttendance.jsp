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
<<<<<<< HEAD

=======
	<%
	List<SignUpModel> userofAttandance = (ArrayList<SignUpModel>) session.getAttribute("userofAttandance");
	List<AttandanceModel> UpdatedUserofAttandance = (ArrayList<AttandanceModel>) session
			.getAttribute("UpdatedUserofAttandance");
	String nullAttandance = (String) session.getAttribute("nouserforAttandance");%>
>>>>>>> main

	<div class="text-center">
		<%
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

			
			<input type="submit" value="Mark">
		</form>
		<%
			}}
			%>
	</div>
</body>
</html>