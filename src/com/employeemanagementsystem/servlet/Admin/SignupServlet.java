package com.employeemanagementsystem.servlet.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.employeemanagementsystem.DAO.Admin.SignUpDao;
import com.employeemanagementsystem.DAO.Admin.UserListDao;
import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.Admin.SignUpModel;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SignUpDao users = new SignUpDao();
	UserListDao usersData = new UserListDao();
// DB connection#####################################################################
//	static private Connection dbConnection = Dbconnection.getconnect();
//	SQL command@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	private static final String find_user = "select * from users where id=?";

	public SignupServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("edit_user"));
//		System.out.println("In edit function");
		if (ID > 0) {
			try {
				userEdit(request, response);
			} catch (IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		End function*********************************************************
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			signUp(request, response);			
}
		
//	Post Function for Sign up users*********************************************************
	protected void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String fname = request.getParameter("fname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String Gender = request.getParameter("Gender");
		String Role = request.getParameter("Role");
		String contactnumber = request.getParameter("contactnumber");
		SignUpModel userSignup = new SignUpModel(fname, username, password, Gender, Role, contactnumber);
		SignUpDao SignUpNew = new SignUpDao();
		SignUpNew.SignUp(userSignup);
		session.setAttribute("UserAdded", "User Added successfully!");
		response.sendRedirect("Admin/Signup.jsp");
	}
//	Get Function for user edit****************************************************************
	protected void userEdit(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		HttpSession session = request.getSession();
		int userID = Integer.parseInt(request.getParameter("edit_user"));
		List<SignUpModel> userUpdateData = users.editUser(userID);
		session.setAttribute("userUpdateData", userUpdateData);
		response.sendRedirect("Admin/Signup.jsp");
//		System.out.println("In edit function");
//				RequestDispatcher dispatch = request.getRequestDispatcher("Admin/UserList.jsp");
//				dispatch.forward(request, response);
//	**********************End function*******************************************************
	}

	
	
	
	
	
	
	
	// *****End
	// Class*************************************************************************************************************
}
