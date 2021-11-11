<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.employeemanagementsystem.dbconnection.Dbconnection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="Allcomp/allcomp.jsp"%>

<title>Login</title>
</head>

<body>
	<%
	if (request.getSession(false).getAttribute("USER") != null) {
		response.sendRedirect(request.getContextPath()+"/Dashboard.jsp");
	}

	else	if (request.getSession(false).getAttribute("ADMIN") != null) {
		response.sendRedirect(request.getContextPath()+"/Admin/Admindashboard.jsp");
	}
	%>
	

	<form class="m-1" action="Welcome.jsp">
		<input type="submit" value="Welcome">
	</form>

	<h1 class="text-center">Employee Management Login</h1>
	<div class="d-flex justify-content-center">

		<form action="<%=request.getContextPath()%>/UserServlet" method="post">

			<table>
				<tr>
					<td><input type="email" name="username" placeholder="Username" /></td>
				</tr>
				<tr>
					<td><input type="password" name="password"
						placeholder="Password" /></td>
				</tr>
				<tr>
					<td><input class="m-1" type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>
	</div>
	<%
	String invalidmsg = (String) session.getAttribute("loginfail");
	if (invalidmsg != null) {
	%>
	<div class="d-flex justify-content-center text-danger"><%=invalidmsg%></div>
	<%
	session.removeAttribute("loginfail");
	}
	%>
</body>
</html>