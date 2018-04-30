package com.edu.test.util;

import org.junit.Test;

import com.edu.protal.util.Base64Utils;

public class Base64Test {
	
	@Test
	public void test() {
		String string = Base64Utils.encodeBase64("123456");
		System.out.println(string);
	}
}
