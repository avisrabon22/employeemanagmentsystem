package com.employeemanagementsystem.servlet.Admin;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.employeemanagementsystem.DAO.Admin.SignUpDao;
import com.employeemanagementsystem.model.Admin.SignUpModel;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				userEditInDBs(request, response);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	// Post function for user edit****************************************************************
	@SuppressWarnings("unused")
	protected void userEditInDBs(HttpServletRequest request, HttpServletResponse response) throws
	IOException, SQLException, ServletException {
		HttpSession session = request.getSession();
		int ID = Integer.parseInt(request.getParameter("ID"));
		String fname = request.getParameter("fname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String Gender = request.getParameter("Gender");
		String Role = request.getParameter("Role");
		String contactnumber = request.getParameter("contactnumber");

		SignUpModel userUpdate = new SignUpModel(ID, fname, username, password, Gender, Role, contactnumber);
		SignUpDao userUpdateNew = new SignUpDao();
		userUpdateNew.updateUserDBs(userUpdate);
		
		response.sendRedirect("UserListServlet");
	}

	
	
	
	
	
//	End Class
}
