package com.way2learnonline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsTest {
	
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("integration-beans.xml");
		
		
		System.out.println("Started");
	}

}
