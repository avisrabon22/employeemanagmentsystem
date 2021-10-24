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
		<form action="" method="post">
			<div class="m-1">
				<label>Name: </label><input type="text" value="<%=profileModel.getFname()%>" readonly/>
			</div>
			<div class="m-1">
				<label>Password: </label><input type="text" value="<%=profileModel.getPassword()%>" readonly/>
			</div>
			<div class="m-1">
				<label>Gender: </label><input type="text" value="<%=profileModel.getGender()%>" readonly/>
			</div>
			<div class="m-1">
				<label>Contact Number: </label><input type="text" value="<%=profileModel.getContactnumber()%>" readonly/>
			</div>
			<input class="m-1" type="submit" value="Submit" /><input type="button"
				value="  Edit  " />
		</form>
	</div>
	<%}}%>
</body>
</html>