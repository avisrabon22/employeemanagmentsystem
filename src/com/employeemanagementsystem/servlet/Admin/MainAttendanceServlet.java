package com.employeemanagementsystem.servlet.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.DAO.Admin.UploadAttandanceDao;
import com.employeemanagementsystem.model.Admin.AttandanceAdminModel;

@WebServlet("/MainAttendanceServlet")
public class MainAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UploadAttandanceDao AttendaceList = new UploadAttandanceDao();

	public MainAttendanceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		AttendaceList = new UploadAttandanceDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			showAttendance(request, response);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("In attendance get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insertAttendance(request, response);
	}

//	Post function************************************
	protected void insertAttendance(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		int ID = Integer.parseInt(request.getParameter("ID"));
		String name = request.getParameter("Name");
		String username = request.getParameter("Username");
		String Date = request.getParameter("Date");
		String InTime = (String) request.getParameter("InTime");
		String OutTime = (String) request.getParameter("OutTime");
		String Status = (String) request.getParameter("Status");

		AttandanceAdminModel insertAttendance = new AttandanceAdminModel(ID, name, username, Date, InTime, OutTime, Status);
		UploadAttandanceDao AttendaceInsert = new UploadAttandanceDao();
//        System.out.println(ID);
		try {
			AttendaceInsert.insertAttandance(insertAttendance);
			session.setAttribute("Userattendance", "Attendance Submited");
			response.sendRedirect("Admin/UserList.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void showAttendance(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		HttpSession session = request.getSession();
		UploadAttandanceDao showAttendance = new UploadAttandanceDao();
		List<AttandanceAdminModel> showAttend = showAttendance.showAttendance();
		session.setAttribute("showAttendace", showAttend);
		response.sendRedirect("Admin/ShowAttendance.jsp");
	}

	// End
	// class**********************************************************************************
}
