package com.way2learnonline;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReceiverUsingListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("jms.xml");
		System.out.println("Receiver started");

	}

}
