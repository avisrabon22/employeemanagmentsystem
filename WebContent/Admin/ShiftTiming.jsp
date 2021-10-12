<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shift Timing</title>
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

</body>
</html>