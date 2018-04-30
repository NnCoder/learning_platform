package com.edu.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtil {
	
	private static String hashAlgorithmName = "MD5";
       
	public static String encodeUseMD5(String credentials,int hashIterations) {
		 return new SimpleHash(hashAlgorithmName, credentials, null, hashIterations).toString();
	}
	
	public static String encodeUseMD5(String credentials) {
		return encodeUseMD5(credentials, 2);
	}
	
	public static void main(String[] args) {
		String md5 = encodeUseMD5("adminadmin");
		System.out.println(md5);
	}
}
