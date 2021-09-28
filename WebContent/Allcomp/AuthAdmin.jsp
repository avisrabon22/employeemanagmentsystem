<%
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
if (session.getAttribute("ADMIN") == null) {
	/* session.invalidate(); */
	response.sendRedirect("../Welcome.jsp");
	
}
%>