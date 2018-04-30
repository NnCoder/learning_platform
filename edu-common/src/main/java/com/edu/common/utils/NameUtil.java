package com.edu.common.utils;

import java.util.UUID;

/**
 * 文件名生成器
 * @Description TODO
 * @ClassName NameUtil
 * @author Tao
 * @date 2018年1月31日
 */
public class NameUtil {
	
	public static void main(String[] args) {
		String name = getName();
		String file = "123.mp3.mp4";
		name = name + file.substring(file.lastIndexOf("."));
		System.out.println(name);
	}
	
	public static String getName() {
		String name = UUID.randomUUID().toString();
		name = name.replace("-", "");
		return name;
	}
}
