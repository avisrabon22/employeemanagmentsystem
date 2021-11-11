<%@page import="java.util.List"%>
<%@page import="com.employeemanagementsystem.model.Admin.SignUpModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/Allcomp/allcomp.jsp"%>
<%@ include file="/Allcomp/navbar.jsp"%>
<%@ include file="/Allcomp/AuthAdmin.jsp"%>

<title>Signup</title>
</head>


<body>
	<%-- <%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("ADMIN") == null) {
		/* session.invalidate(); */
		response.sendRedirect("../Welcome.jsp");
	}
	%> --%>

	<h1 class="text-center">ADD USER</h1>
	<div class="d-flex justify-content-center">
		<%
		List<SignUpModel> update = (List<SignUpModel>) session.getAttribute("userUpdateData");
		String Signup=(String)session.getAttribute("Signup");
		
		if (update != null) {
			for (SignUpModel updates : update) {
		%>
		<!--*********Update form**************************************************************************************-->
		<form action="<%=request.getContextPath()%>/UpdateUserServlet"
			method="post">
			<!--*****************************************************************************-->
			<div class="mb-1">
				<input type="number" required name="ID" placeholder="ID" readonly
					value="<%=updates.getID()%>" />
			</div>
			<div class="mb-1">
				<input type="text" required name="fname" placeholder="*Full Name"
					value="<%=updates.getFullName()%>" />
			</div>
			<div class="mb-1">
				<input type="email" required name="username" placeholder="*Username"
					value="<%=updates.getUsername()%>" />
			</div>
			<div class="mb-1">
				<input type="password" required name="password"
					placeholder="*Password" value="<%=updates.getPassword()%>" />
			</div>
			<!--*****************************************************************************  -->
			<label>*Gender:-----></label>
			<div class="mb-1">
				<label for="Gender" class="m-1">Male</label><input type="radio"
					value="Male" name="Gender" /> <label for="Gender" class="m-1">Female</label><input
					type="radio" value="Female" name="Gender" /> <label for="Gender"
					class="m-1">Other</label><input type="radio" name="Gender"
					value="Other">
			</div>
			<div class="m-2">
				<label>*</label><select name="Role" id="Role" required>
					<option selected disabled>Choose your user</option>
					<option value="ADMIN">Admin</option>
					<option value="USER">Normal user</option>
				</select>
			</div>
			<div>
				<input type="number" required name="contactnumber"
					placeholder="*Contact Number"
					value="<%=updates.getContactNumber()%>" />
			</div>
			<!--****************************************************************************************  -->
			<input type="submit" value="UPDATE" class="m-1" />
		</form>
		<%
		}
		session.removeAttribute("userUpdateData");
		} else if(Signup!=null) {
		%>
		<!--********************Insert form***************************************************************************-->
		<form action="<%=request.getContextPath()%>/SignupServlet"
			method="post">
			<!--*****************************************************************************-->
			<div class="mb-1">
				<input type="text" required name="fname" placeholder="*Full Name"
					value="" />
			</div>
			<div class="mb-1">
				<input type="email" required name="username" placeholder="*Username"
					value="" />
			</div>
			<div class="mb-1">
				<input type="password" required name="password"
					placeholder="*Password" value="" />
			</div>
			<!--*****************************************************************************  -->
			<label>*Gender:-----></label>
			<div class="mb-1">
				<label for="Gender" class="m-1">Male</label><input checked
					type="radio" value="Male" name="Gender" /> <label for="Gender"
					class="m-1">Female</label><input type="radio" value="Female"
					name="Gender" /> <label for="Gender" class="m-1">Other</label><input
					type="radio" name="Gender" value="Other">
			</div>
			<div class="m-2">
				<label>*</label><select name="Role" required>
					<option selected disabled>Choose your user</option>
					<option value="ADMIN">Admin</option>
					<option value="USER">Normal user</option>
				</select>
			</div>
			<div>
				<input type="number" required name="contactnumber"
					placeholder="*Contact Number" />
			</div>
			<!--****************************************************************************************  -->
			<input type="submit" value="ADD" class="m-1" /><input type="reset"
				value="RESET" class="m-1" />
		</form>
		<%
		}
		%>
	</div>

	<!--********************Added success**********************************************-->
	<%
	String useradd = (String) session.getAttribute("UserAdded");
	String userupdate = (String) session.getAttribute("UserUpdate");
	String usernotupdate = (String) session.getAttribute("UserNotUpdate");
	if (useradd != null) {
	%>
	<div class="d-flex justify-content-center text-success"><%=useradd%></div>
	<%
	session.removeAttribute("UserAdded");
	} else if (userupdate != null) {
	%>
	<div class="d-flex justify-content-center text-success"><%=userupdate%></div>
	<%
	session.removeAttribute("UserUpdate");
	} else if (usernotupdate != null) {
	%>
	<div class="d-flex justify-content-center text-success"><%=usernotupdate%></div>
	<%
	session.removeAttribute("UserNotUpdate");
	}
	%>
</body>
</html>