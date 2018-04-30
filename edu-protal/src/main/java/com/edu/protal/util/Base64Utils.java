package com.edu.protal.util;

import org.apache.shiro.codec.Base64;

public class Base64Utils {
	/*
     * base64加密
     * */
    public static String encodeBase64(String str) {
        return Base64.encodeToString(str.getBytes());
    }
    /*
     * base64解密
     * */
    public static String decodeBase64(String str) {
        return Base64.decodeToString(str);
    }
}
