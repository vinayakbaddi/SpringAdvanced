package com.way2learnonline;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("integration-beans.xml");
		

	}

}
