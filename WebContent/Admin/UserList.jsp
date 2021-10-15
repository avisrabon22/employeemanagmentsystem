<%@page import="javax.servlet.annotation.ServletSecurity"%>
<%@page import="com.employeemanagementsystem.model.Admin.SignUpModel"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<%@ include file="/Allcomp/allcomp.jsp"%>
<%@ include file="/Allcomp/navbar.jsp"%>
</head>


<body>
	<%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("ADMIN") == null) {
		/* session.invalidate(); */
		response.sendRedirect("../Welcome.jsp");
	}
	%>

	<a href="<%=request.getContextPath()%>/UserListServlet"
		class="nav-link">Users</a>

	<a
		href="http://localhost:8080/employeemanagementsystem/Admin/Signup.jsp"
		class="nav-link">Add User</a>
	<h1 class="text-center">User List</h1>
	<%String userAttend=(String)session.getAttribute("Userattendance");
	if(userAttend!=null){
	%>
	<h1><%=userAttend%></h1>
<%}session.removeAttribute("Userattendance");%>

<%String userUpdate=(String)session.getAttribute("updateUsers");
if(userUpdate!=null){
%>
<p class="text-center text-success"><%=userUpdate%></p>
<%session.removeAttribute("updateUsers");}%>
	<%-- 	<%
String emptyList=(String)session.getAttribute("UserListEmpty");
if(UserList==null){
%>
<h1><%=emptyList%></h1>
<%}%> --%>

	<!--***************************************User LIst**********************************************-->
	<div class="container-fluid">
		<table class="table table-bordered table-striped">
			<thead>
				<tr class="text-center">
					<th>ID</th>
					<th>Full Name</th>
					<th>Username</th>
					<th>Password</th>
					<th>Gender</th>
					<th>User Type</th>
					<th>Contact Number</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>

			<%
			List<SignUpModel> users = (ArrayList<SignUpModel>) session.getAttribute("userlist");
			if (users == null) {
			%>
			<tr class="text-center">
				<td>Go to main and return</td>
			</tr>
			<%
			} else
			for (SignUpModel user : users) {
			%>
			<tbody>
				<tr class="text-center">
					<td><%=user.getID()%></td>
					<td><%=user.getFullName()%></td>
					<td><%=user.getUsername()%></td>
					<td><%=user.getPassword()%></td>
					<td><%=user.getGender()%></td>
					<td><%=user.getRole()%></td>
					<td><%=user.getContactNumber()%></td>
					<td><a
						href="<%=request.getContextPath()%>/SignupServlet?edit_user=<%=user.getID()%>">Edit</a>
					<td><a
						href="<%=request.getContextPath()%>/UserListServlet?delete_user=<%=user.getID()%>">Delete</a></td>
					<td><a
						href="<%=request.getContextPath()%>/UploadAttendanceServlet?mark_attendance=<%=user.getID()%>">Mark
							Attendance</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>


</html>