package com.edu.cookie;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;


public class CookieTest {
	
	
	@Test
	public void testCookie() {
		int a=10,b=4,c=5,d=9; 
		System.out.println(++a*b+c*--d); 
	}
}
