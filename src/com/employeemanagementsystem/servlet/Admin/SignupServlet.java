package com.employeemanagementsystem.servlet.Admin;

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

import com.employeemanagementsystem.DAO.Admin.SignUpDao;
import com.employeemanagementsystem.model.Admin.SignUpModel;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		SignUpDao Signup=new SignUpDao();
		int editID=Integer.parseInt(request.getParameter("edit_user"));
		try {
			List<SignUpModel>findUserForUpdate=Signup.editUser(editID);
			session.setAttribute("userUpdateData", findUserForUpdate);
			response.sendRedirect("Admin/Signup.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.print("In");
		HttpSession session=request.getSession();
		SignUpDao Signup=new SignUpDao();
		
		String Fname=(String)request.getParameter("fname");
		String username=(String)request.getParameter("username");
		String password=(String)request.getParameter("password");
		String gender=(String)request.getParameter("Gender");
		String role=(String)request.getParameter("Role");
		String contactnumber=(String)request.getParameter("contactnumber");
		SignUpModel signupList=new SignUpModel(Fname,username,password,gender,role,contactnumber); 
		Signup.SignUp(signupList);
		session.setAttribute("UserAdded", "User added successfully !");
		response.sendRedirect("Admin/Signup.jsp");
	}

}
