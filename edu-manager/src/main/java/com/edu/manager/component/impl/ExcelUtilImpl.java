package com.edu.manager.component.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.edu.manager.component.ExcelUtil;

public class ExcelUtilImpl implements ExcelUtil {

	// 测试部分
	/*
	 * public static void main(String[] args) throws FileNotFoundException,
	 * IOException { XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new
	 * File("E://图片素材//test.xlsx"))); XSSFSheet sheet = wb.getSheetAt(0); XSSFRow
	 * row; XSSFCell cell; Object value; int sumRows =
	 * sheet.getPhysicalNumberOfRows(); int firstRowNum = sheet.getFirstRowNum();
	 * for(int i=firstRowNum;i<sumRows;i++) { row = sheet.getRow(i); int colStart =
	 * row.getFirstCellNum(); int colEnd = row.getLastCellNum(); String string = "";
	 * for(int j=colStart;j<colEnd;j++) { cell = row.getCell(j); string +=
	 * cell.getStringCellValue()+" "; } System.out.println(string); } }
	 */
	
	/**
	 * 通用读取方法
	 * @param file StringMVC上传文件
	 * @return 若为可读取excel文件,返回二维数组ArrayList<ArrayList<String>>,若不可读取，返回null
	 * @throws IOException 读取错误抛出异常
	 */
	public ArrayList<ArrayList<String>> readExcel(MultipartFile file) throws IOException{
		String fileName = file.getOriginalFilename();
		//excel读取后返回的结果集
		ArrayList<ArrayList<String>> result = null;
		//根据文件后缀判断excel文件为2007 or 2003
		if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
			result = fileName.endsWith(".xlsx")?this.readExcel2007(file.getInputStream()):this.readExcel2003(file.getInputStream());
		}
		return result;
	}
	
	/**
	 * 读取excel2007版,即后缀为 .xlsx
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public ArrayList<ArrayList<String>> readExcel2007(InputStream in) throws IOException {
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(in);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			ArrayList<ArrayList<String>> result = new ArrayList<>();
			ArrayList<String> rowList;
			int sumRows = sheet.getPhysicalNumberOfRows();
			int firstRowNum = sheet.getFirstRowNum();
			for (int i = firstRowNum; i < sumRows; i++) {
				rowList = new ArrayList<>();
				row = sheet.getRow(i);
				int colStart = row.getFirstCellNum();
				int colEnd = row.getLastCellNum();
				for (int j = colStart; j < colEnd; j++) {
					cell = row.getCell(j);
					String str = getXSSFCellString(cell);
					str = str == null ? "" : str; // 空值处理
					rowList.add(str);
				}
				result.add(rowList);
			}
			return result;
		} finally {
			// 关闭流
			if (wb != null) {
				wb.close();
			}
			in.close();
		}

	}
	
	private static String getXSSFCellString(XSSFCell cell) {
		CellType cellTypeEnum = cell.getCellTypeEnum();
		switch (cellTypeEnum) {
		case STRING:
			return cell.getStringCellValue();
			
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		default:
			return cell.getStringCellValue();
		}
	}
	private static String getHSSFCellString(HSSFCell cell) {
		CellType cellTypeEnum = cell.getCellTypeEnum();
		switch (cellTypeEnum) {
		case STRING:
			return cell.getStringCellValue();
			
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		default:
			return cell.getStringCellValue();
		}
	}
	/**
	 * 读取excel2003版,即后缀为 .xls
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public ArrayList<ArrayList<String>> readExcel2003(InputStream in) throws IOException {
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook(in);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;
			ArrayList<ArrayList<String>> result = new ArrayList<>();
			ArrayList<String> rowList;
			int sumRows = sheet.getPhysicalNumberOfRows();
			int firstRowNum = sheet.getFirstRowNum();
			for (int i = firstRowNum; i < sumRows; i++) {
				rowList = new ArrayList<>();
				row = sheet.getRow(i);
				int colStart = row.getFirstCellNum();
				int colEnd = row.getLastCellNum();
				for (int j = colStart; j < colEnd; j++) {
					cell = row.getCell(j);
					String str = getHSSFCellString(cell);
					str = str == null ? "" : str; // 空值处理
					rowList.add(str);
				}
				result.add(rowList);
			}
			return result;
		} finally { 
			//finally处理，防止上传文件中断出现流未关闭问题导致线程阻塞与资源浪费
			// 关闭流
			if (wb != null) {
				wb.close();
			}
			in.close();
		}

	}

}
