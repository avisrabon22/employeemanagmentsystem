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

import com.employeemanagementsystem.DAO.Admin.ShowReportDao;
import com.employeemanagementsystem.model.Admin.ShowReportModel;

@WebServlet("/ShowReportServlet")
public class ShowReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShowReportDao showReport = new ShowReportDao();

	public ShowReportServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("Welcome to report");
		HttpSession session = request.getSession();
		try {
			List<ShowReportModel> Report = showReport.getReport();
			if (Report == null) {
				session.setAttribute("noReport", "No Report!");;
				response.sendRedirect("Admin/UploadReport.jsp");
			} else if (Report != null) {
				session.setAttribute("Report", Report);
				response.sendRedirect("Admin/UploadReport.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
