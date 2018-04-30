package com.edu.manager.component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelUtil {
	public ArrayList<ArrayList<String>> readExcel(MultipartFile file) throws IOException;
	ArrayList<ArrayList<String>> readExcel2007(InputStream in) throws IOException;
	ArrayList<ArrayList<String>> readExcel2003(InputStream in) throws IOException;
}
