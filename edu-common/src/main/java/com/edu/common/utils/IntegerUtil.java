package com.edu.common.utils;

public class IntegerUtil {
	
	public static int parseInt(String value) {
		try {
			double dint = Double.parseDouble(value);
			return (int)dint;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
