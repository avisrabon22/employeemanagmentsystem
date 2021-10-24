package com.employeemanagementsystem.servlet.Admin;

// Java Package*****************************************************************
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.DAO.Admin.UserListDao;
import com.employeemanagementsystem.model.Admin.SignUpModel;
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserListDao users = new UserListDao();

	public UserListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		users = new UserListDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	*************************************************************************************************	
		 if(request.getParameter("delete_user")!=null ) {
			try {
				userDelete(request,response);
			} catch (IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			try {
				userList(request,response);
			} catch (IOException | ServletException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//End function	
	}
//Get UserList Function***************************************************************************************************
	protected void userList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		HttpSession session = request.getSession();
		List<SignUpModel> userlist = users.UserList();
		if (userlist == null) {
			response.sendRedirect("Admin/Admindashboard.jsp");
		} else {
			session.setAttribute("userlist", userlist);
			response.sendRedirect("Admin/UserList.jsp");
//			RequestDispatcher dispatch = request.getRequestDispatcher("Admin/UserList.jsp");
//			dispatch.forward(request, response);
		}
	}
	//Get UserDelete Function***************************************************************************************************
	protected void userDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		int userID = Integer.parseInt(request.getParameter("delete_user"));
		users.deleteUser(userID);
//		System.out.println("In delete function");
//		userList(request,response);
		response.sendRedirect("UserListServlet");
	
//				RequestDispatcher dispatch = request.getRequestDispatcher("Admin/UserList.jsp");
//				dispatch.forward(request, response);
//	**********************End function*******************************************************
	}


	

//End Class
}