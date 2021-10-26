package com.employeemanagementsystem.servlet.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();  
		String filename = "Report.xlsx";   
		  String filepath = "C:\\Users\\Avijit\\git\\employeemanagmentsystem\\WebContent\\DownloadFiles\\";   
		  response.setContentType("APPLICATION/OCTET-STREAM");   
		  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
		  
		  java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath + filename);  
		            
		  int i;   
		  while ((i=fileInputStream.read()) != -1) {  
		     out.write(i);
		  }   
		  fileInputStream.close(); 
		  out.close();
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
