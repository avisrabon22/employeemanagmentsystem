package com.employeemanagementsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.DAO.AttendanceDao;
import com.employeemanagementsystem.DAO.ReportDao;
import com.employeemanagementsystem.model.AttendanceModel;
import com.employeemanagementsystem.model.ReportModel;

@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public AttendanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		AttendanceDao forAttendance=new AttendanceDao();
	String username=(String)request.getAttribute("username");
			List<AttendanceModel> userAttendance =new ArrayList<AttendanceModel>();
			try {
				userAttendance =forAttendance.getAttendance();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("userAttendance", userAttendance);
			response.sendRedirect("Attendance.jsp");	
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
