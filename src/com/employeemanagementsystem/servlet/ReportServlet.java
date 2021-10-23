package com.employeemanagementsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.DAO.ReportDao;
import com.employeemanagementsystem.model.ReportModel;


@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
//		System.out.println("In Report");
		
	ReportDao forUsers=new ReportDao();
	try {
		List<ReportModel> userReport=forUsers.getReport();
		session.setAttribute("userReport", userReport);
		response.sendRedirect("Report.jsp");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
