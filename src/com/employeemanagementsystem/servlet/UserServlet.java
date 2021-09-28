package com.employeemanagementsystem.servlet;

import java.io.IOException;
//import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.DAO.UserDao;
//import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.employeemanagementsystem.model.UsersDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
//**********************************************************************
		UsersDetails usersDetails = new UsersDetails();

		usersDetails.setUsername(username);
		usersDetails.setPassword(password);
//**********************************************************************		
		UserDao userDao = new UserDao();
		try {
			String userloginData = userDao.userLogin(usersDetails);

			if (userloginData.equals("ADMIN_ROLE")) {
				session.setAttribute("ADMIN", username);
				session.setAttribute("password", password);
				request.setAttribute("username", username);
				response.sendRedirect("Admin/Admindashboard.jsp");
				
			}
//**********************************************************************			
			else if (userloginData.equals("USER_ROLE")) {
				session.setAttribute("USER", username);
				session.setAttribute("password", password);
				request.setAttribute("username", username);
				response.sendRedirect("Dashboard.jsp");
			}
//**********************************************************************			
			else {
				session.setAttribute("loginfail", "Invalid username or password!");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
//				response.sendRedirect("Login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}