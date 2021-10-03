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
import com.employeemanagementsystem.model.Admin.SignUpModel;


@WebServlet("/UploadAttendanceServlet")
public class UploadAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UploadAttandanceDao fectUserForAttandance=new UploadAttandanceDao();
 
    public UploadAttendanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() {
    	fectUserForAttandance=new UploadAttandanceDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			List<SignUpModel> userofAttandance=fectUserForAttandance.userListForAttandance();
			if(request.getParameter("Role")!=null){
				if(userofAttandance==null) {
					session.setAttribute("nouserforAttandance", "No User Exist!!");
					response.sendRedirect("Admin/mainAttendance.jsp");
				}
				session.setAttribute("userofAttandance", userofAttandance);
			response.sendRedirect("Admin/mainAttendance.jsp");
			}else {
				session.setAttribute("nullattend", "Select user type");
				response.sendRedirect("Admin/UploadAttendance.jsp");
				System.out.println("Null In Attendance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
