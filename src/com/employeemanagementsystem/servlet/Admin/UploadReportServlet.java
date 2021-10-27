package com.employeemanagementsystem.servlet.Admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.employeemanagementsystem.DAO.Admin.UploadReportDao;

@WebServlet("/UploadReportServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)

public class UploadReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadReportServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Uploading file to server******************************************************
		HttpSession session = request.getSession();
		String uploadFile="C:/Users/Avijit/git/employeemanagmentsystem/WebContent/UploadedFiles/";
		Part UploadFilePart = request.getPart("uploadfile");
		String fileName = UploadFilePart.getSubmittedFileName();
		if (fileName != null) {
			for (Part part : request.getParts()) {
				part.write( uploadFile+ fileName);
			}
			UploadReportDao uploadDao=new UploadReportDao();
			try {
				uploadDao.dataimport(uploadFile+fileName);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("uploadDone", "File uploaded !");
			response.sendRedirect("Admin/UploadReport.jsp");
			System.out.print("The file uploaded sucessfully.");
		} else {
			session.setAttribute("uploadfile", "Please upload the file");
			response.sendRedirect("Admin/UploadReport.jsp");
		}
		
	}

}
