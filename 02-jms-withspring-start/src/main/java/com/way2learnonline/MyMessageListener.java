package com.way2learnonline;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class MyMessageListener implements MessageListener {
	
	/*@Autowired
	private JmsTemplate jmsTemplate;*/

	public void onMessage(Message message) {
		
		TextMessage tmessage=(TextMessage)message;
		
		 try {
			System.out.println("Received : "+tmessage.getText());
			//Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// jmsTemplate.convertAndSend("replyqueue", "Message id processed");
		/* if(true){
			 throw new RuntimeException("Just for testing");
		 }*/

	}

	

}
