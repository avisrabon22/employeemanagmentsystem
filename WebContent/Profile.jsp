<%@page import="com.employeemanagementsystem.model.ProfileModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="Allcomp/allcomp.jsp"%>
<%@ include file="Allcomp/navbar.jsp"%>
<title>Profile</title>
</head>


<body>
	<%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if (request.getSession(false).getAttribute("USER") == null) {
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
	%>

<%List<ProfileModel> profile=(List<ProfileModel>)session.getAttribute("profile");
if(profile!=null){
%>
	<h1 class="text-center">Profile</h1>
	<%for(ProfileModel profileModel:profile){%>
	<div class="text-center">
		<form action="<%=request.getContextPath()%>profileservlet" method="post">
			<div class="m-1">
				<label class="m-1">Name: </label><input type="text" value="<%=profileModel.getFname()%>" readonly/>
			</div>
			<div class="m-1">
				<label class="m-1">Password: </label><input type="password" value="<%=profileModel.getPassword()%>" readonly/>
			</div>
			<div class="m-1">
				<label class="m-1">Gender: </label><input type="text" value="<%=profileModel.getGender()%>" readonly/>
			</div>
			<div class="m-1">
				<label class="m-1">Contact Number: </label><input type="text" value="<%=profileModel.getContactnumber()%>" readonly/>
			</div>
		</form>
	</div>
	<%}}%>
</body>
</html>