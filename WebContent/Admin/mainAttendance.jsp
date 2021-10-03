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
	<%List<SignUpModel> userofAttandance=(ArrayList<SignUpModel>)session.getAttribute("userofAttandance");
	String nullAttandance=(String)session.getAttribute("nouserforAttandance");
	if(nullAttandance!=null){
	%>
	<p class="text-center"><%=nullAttandance%></p>
	<%}else{%>
	<form class="text-center" action="" method="post">
		<%for( SignUpModel userAttandance:userofAttandance){%>
		<div class="text-center">
			<span><input disabled name="ID" type="text"
				value="<%=userAttandance.getID()%>" placeholder=""></span> <span><input disabled
				name="Name" type="text" value="<%=userAttandance.getFullName()%>"
				placeholder=""></span> <span><input Name="InTime"
				type="time" placeholder="In Time"></span> <span><input
				Name="OutTime" type="time" placeholder="Out Time"></span> <span><input
				Name="Status" type="text" placeholder="Status"></span> <input
				type="submit" value="Mark">
		</div>
		<%}}%>
	</form>





</body>
</html>