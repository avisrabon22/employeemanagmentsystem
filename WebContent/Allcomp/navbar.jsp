<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
	<%
				if (request.getSession(false).getAttribute("USER") != null) {
				%>
				<a class="navbar-brand">Employee Portal</a>
				<%
				} else if(request.getSession(false).getAttribute("ADMIN") != null) {
				%>
				<a class="navbar-brand">Admin Portal</a>
				<%
				}
				%>
		
		
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<%
				if (request.getSession(false).getAttribute("USER") != null) {
				%>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="Dashboard.jsp">Dashboard</a></li>
				<%
				} else if(request.getSession(false).getAttribute("ADMIN") != null) {
				%>
				<li class="nav-item "><a class="nav-link active text-primary"
					aria-current="page" href="Admindashboard.jsp">Admin
						Dashboard</a></li>
				<%
				}
				%>
			</ul>
			<form action="<%=request.getContextPath()%>/LogoutServlet">
				<input type="submit" value="Logout" />
			</form>

		</div>
	</div>
</nav>