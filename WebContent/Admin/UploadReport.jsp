<%@page import="java.util.List"%>
<%@page
	import="com.employeemanagementsystem.model.Admin.ShowReportModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="/Allcomp/allcomp.jsp"%>
<%@ include file="/Allcomp/navbar.jsp"%>
<%@ include file="/Allcomp/AuthAdmin.jsp"%>
<title>Upload Report</title>
</head>
<body>
	<div class="m-1 btn">
		<form action="<%=request.getContextPath()%>/ShowReportServlet"
			method="get">
			<input type="submit" value="Show Report" />
		</form>
	</div>
	<!--******************************************************************************-->
	<div class="m-1 btn">
		<form action="<%=request.getContextPath()%>/ClearReportServlet"
			method="get">
			<input type="submit" value="Clear Report" />
		</form>
	</div>
	<!--*****************************************************************************  -->
	<div class="text-center">
		<h1 class="text-center">Upload Report</h1>
		<!--*************************Upload file**************************************************-->
		<form action="<%=request.getContextPath()%>/UploadReportServlet"
			method="post" enctype="multipart/form-data">
			<div>
				<input type="file" name="uploadfile" accept=".xls,.xlsx" />
			</div>
			<!--*************************Download formated file************************************-->
			<div>
				<a href="<%=request.getContextPath()%>/DownloadServlet">Download
					the formated file(Mandatory)</a>
			</div>

			<div class="m-1">
				<input type="submit" value="Upload" />
			</div>
		</form>
		<!--****************Status display***************-->
		<%
		String uploadDone = (String) session.getAttribute("uploadDone");
		String uploadfile = (String) session.getAttribute("uploadfile");
		if (uploadDone != null) {
		%>
		<p style="color: green"><%=uploadDone%></p>
		<%
		session.removeAttribute("uploadDone");
		} else if (uploadfile != null) {
		%>
		<p style="color: red"><%=uploadfile%></p>
		<%
		session.removeAttribute("uploadfile");
		}
		%>
	</div>
	<!--**************************************************************************************-->
	<%
	List<ShowReportModel> Report = (List<ShowReportModel>) session.getAttribute("Report");
	String noReport = (String) session.getAttribute("noReport");
	%>
	<div>
		<%
		if (Report != null) {
		%>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Date</th>
					<th>Login Time</th>
					<th>Logout Time</th>
					<th>Working Time</th>
				</tr>
			</thead>
			<!--*****************************************************************************-->
			<tbody>
				<%
				for (ShowReportModel report : Report) {
				%>
				<tr>
					<td><%=report.getId()%></td>
					<td><%=report.getName()%></td>
					<td><%=report.getDate()%></td>
					<td><%=report.getLogintime()%></td>
					<td><%=report.getLogouttime()%></td>
					<td><%=report.getWorkingtime()%></td>

				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		session.removeAttribute("Report");
		
		}
		%>
	</div>
</body>
</html>