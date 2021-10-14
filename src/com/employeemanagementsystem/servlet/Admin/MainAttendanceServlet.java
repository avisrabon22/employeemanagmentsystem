package com.employeemanagementsystem.servlet.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.DAO.Admin.UploadAttandanceDao;

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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.getAttribute("InTime");
		session.getAttribute("OutTime");
		session.getAttribute("Status");

	}

}
