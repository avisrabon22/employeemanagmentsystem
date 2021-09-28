package com.employeemanagementsystem.servlet.Admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.employeemanagementsystem.DAO.Admin.UploadReportDao;

@WebServlet("/UploadReport")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UploadReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

//	Path of the files************************************************************************************************
	public static String filePath = "C:/Users/Avi/OneDrive/B.Sc.(IT)/6th Semester/BIT604-Major Project/EMP/WebContent/UploadedFiles/";
//	Get ***********************************************************************************
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{

	}
//	Post##################################################################################
	@SuppressWarnings({ })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
//	System.out.println("uploadsheet");
//		Uploaded sheet *********************************************
		UploadReportDao uploadreportdao = new UploadReportDao();
//**************************************************************************
		HttpSession session = request.getSession();
		Part files = request.getPart("uploadfile");
		String FileName = files.getSubmittedFileName();
//***************************************************************************
		if (FileName.isEmpty()) {
			session.setAttribute("uploadfile", "Please upload file");
			response.sendRedirect("Admin/UploadReport.jsp");
//				Upload to Database********************************************************				
		} else {
			try {
				// Save the file to server************************************************
				for (Part upload : request.getParts()) {
					upload.write(filePath + FileName);
				}
				System.out.println("File Uploaded");
				String UploadedFile = filePath + FileName;
				System.out.println(UploadedFile);
				 uploadreportdao.dataimport(UploadedFile);

			} catch (Exception e) {
				System.out.println(e);
			}

			session.setAttribute("uploadDone", "Uploaded successfully!!");
			response.sendRedirect("Admin/UploadReport.jsp");
		}
	}
}
