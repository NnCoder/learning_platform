package com.edu.common.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	
	public static void transferTo(InputStream in, File toFile) {
		BufferedInputStream buffIn = null;
		FileOutputStream fout = null;
		try {
			buffIn = new BufferedInputStream(in);
			fout = new FileOutputStream(toFile);
			byte[] buff = new byte[2048];
			int length = 0;
			while((length=buffIn.read(buff))!=-1) {
				fout.write(buff, 0, length);
			}
			fout.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(buffIn!=null) {
				try {
					buffIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fout!=null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
