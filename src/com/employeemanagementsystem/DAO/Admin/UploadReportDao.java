package com.employeemanagementsystem.DAO.Admin;

//Import packages***********************************************
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import com.employeemanagementsystem.dbconnection.Dbconnection;
import com.mongodb.internal.connection.Time;

//Starting of the main class*********************************************************************************************************
public class UploadReportDao {

//	Importing data to database from uploaded file******************************************************************************
	@SuppressWarnings("rawtypes")
	public void dataimport(String UploadedFile) throws SQLException, IOException {
//        Function of Reading data from files***********************************************
		List dataHolder = readExcelFile(UploadedFile);
//		Show the data******************************************
		for (int i = 0; i < dataHolder.size(); i++) {
			List rowData = (List) dataHolder.get(i);
			for (int j = 0; j < rowData.size(); j++) {
				Cell cellData = (Cell) rowData.get(j);

				if (cellData.getCellType() == CellType.STRING) {
					System.out.print(cellData.getStringCellValue());
				} else if (cellData.getCellType() == CellType.NUMERIC) {
					System.out.print(cellData.getNumericCellValue());
				} else if (cellData.getCellType() == CellType.BOOLEAN) {
					System.out.print(cellData.getBooleanCellValue());
				}

				if (j < rowData.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("");
		}

//Database connection***********************************************************
		Connection con = Dbconnection.getconnect();
//		******************************SQL Query**************************************
		String jdbc_insert_sql = "insert into employeereport(id,name,date,logintime,logouttime,workingtime) values(?,?,?,?,?,?)";
//		*****************************************************************************
		PreparedStatement ps = con.prepareStatement(jdbc_insert_sql);
		for (int i = 1; i < dataHolder.size(); i++) {
			List rowData = (List) dataHolder.get(i);
			for (int j = 0; j < rowData.size(); j++) {
				Cell cellData = (Cell) rowData.get(j);
				int IndexCell = cellData.getColumnIndex();

				switch (IndexCell) {
				case 0:
				int id= (int) cellData.getNumericCellValue();
					ps.setInt(1,id);
					break;
				case 1:
					 String name = cellData.getStringCellValue();
					ps.setString(2,name);
					break;
				case 2:
					 String date = cellData.getStringCellValue();
					ps.setString(3,date);
					break;
				case 3:
					String logintime = cellData.getStringCellValue();
					ps.setString(4,logintime);
					break;
				case 4:
					String logouttime = cellData.getStringCellValue();
					ps.setString(5,logouttime);
					break;
				case 5:
					String workingtime = cellData.getStringCellValue();
					ps.setString(6,workingtime);
					break;
					
				}
			}
			ps.executeUpdate();}
		System.out.println("Data inserted");
//		System.out.println(count);
	}

//		}
//
//		System.out.println("Data inserted to database");
//	}

//	Read Data from files**************************************************************************************************

	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public static List readExcelFile(String UploadedFile) throws IOException {

		List dataofFile = new ArrayList();// For Store all data of file
//		For File***********************************************************
		FileInputStream upFile = new FileInputStream(UploadedFile);
//		For Workbook*************************************************
		XSSFWorkbook workbook = new XSSFWorkbook(upFile);
//		For Sheet*****************************************
		XSSFSheet sheet = workbook.getSheetAt(0);
//      For Row**************************************************************
		Iterator<org.apache.poi.ss.usermodel.Row> rows = sheet.rowIterator();
//		rows.next();
		while (rows.hasNext()) {
			org.apache.poi.ss.usermodel.Row row = rows.next();
//			For cell**********************************
			Iterator cells = row.cellIterator();

			List dataofCells = new ArrayList();// For Store all data of cells
			while (cells.hasNext()) {
				org.apache.poi.ss.usermodel.Cell cell = (Cell) cells.next();
				dataofCells.add(cell);// Storing data to cell array
			}
			dataofFile.add(dataofCells);// Storing data to main array
		}
		upFile.close();

		return dataofFile;
	}

//End the main class********************************************************************************************
}
