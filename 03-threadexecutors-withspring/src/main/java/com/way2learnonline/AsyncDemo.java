package com.way2learnonline;

import java.util.concurrent.Future;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AsyncDemo {

	
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("async.xml");
		ASyncMailer aSyncMailer=context.getBean(ASyncMailer.class);
		
		//aSyncMailer.sendMail();
		
		//
		Future<String>returnValue= aSyncMailer.sendMailAndReturn();
		
		System.out.println("Inside Main");
		//
		//
		System.out.println("ReturnValue : " +returnValue.get());
		
		
	}
	
}
