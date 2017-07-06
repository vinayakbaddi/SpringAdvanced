package com.way2learnonline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {

		String springConfig = "spring/batch/jobs/job-report.xml";

		 new ClassPathXmlApplicationContext(springConfig);

	}
}
