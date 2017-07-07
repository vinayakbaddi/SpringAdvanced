package com.way2learnonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

public class MyPOjo {
	
/*	@Autowired
	private JmsTemplate jmsTemplate;*/

	//@Transactional
	public void handle(String message) {
		System.out.println(Thread.currentThread().getName()+" " +message);
		//jmsTemplate.convertAndSend("myreplyq", "This is responsssssseee");
		//
		//
		//
		//
		
	/*	if(message.equals("q")){
			throw new RuntimeException("Just for testinggggggggggggg");
		}*/

	}

	

}
