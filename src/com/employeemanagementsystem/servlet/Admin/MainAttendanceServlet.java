package com.employeemanagementsystem.servlet.Admin;
import java.sql.SQLException;
import java.sql.Time;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.employeemanagementsystem.DAO.Admin.UploadAttandanceDao;
import com.employeemanagementsystem.model.Admin.AttandanceModel;

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

		System.out.println("In attendance get");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insertAttendance(request,response);
	}

		
//	Post function************************************
	protected void insertAttendance(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String Date=request.getParameter("Date");
		String InTime=(String)request.getParameter("InTime");
		String OutTime=(String)request.getParameter("OutTime");
		String Status=(String)request.getParameter("Status");
		int ID=Integer.parseInt(request.getParameter("ID"));
        AttandanceModel insertAttendance=new AttandanceModel(Date,InTime, OutTime, Status,ID);
        UploadAttandanceDao AttendaceInsert = new UploadAttandanceDao();
        System.out.println(ID);
        try {
			AttendaceInsert.insertAttandance(insertAttendance);
			session.setAttribute("Userattendance", "Attendance Submited");
			response.sendRedirect("Admin/UserList.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	End class**********************************************************************************
}
