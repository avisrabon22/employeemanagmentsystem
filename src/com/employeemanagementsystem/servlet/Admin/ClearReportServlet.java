package com.employeemanagementsystem.servlet.Admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.DAO.Admin.ShowReportDao;

/**
 * Servlet implementation class ClearReportServlet
 */
@WebServlet("/ClearReportServlet")
public class ClearReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShowReportDao clearReport = new ShowReportDao();

	public ClearReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            try {
					clearReport.removeReport();
//					System.out.println("Cleared Report");
					response.sendRedirect("Admin/UploadReport.jsp");
					
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
