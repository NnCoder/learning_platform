package com.edu.test.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.protal.service.KpService;


public class KpServiceTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetKpById() {
		ApplicationContext atx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
		KpService kpService = atx.getBean(KpService.class);
		kpService.getKpById(12);
	}

}
