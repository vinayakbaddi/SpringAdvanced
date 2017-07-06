package com.way2learnonline;

import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.apache.activemq.ActiveMQConnectionFactory;



public class MessageSenderDemo {

	public static void main(String[] args) throws Exception {
		InitialContext jndi = new InitialContext();	
		
		QueueConnectionFactory conFactory = (QueueConnectionFactory)
				jndi.lookup("connectionFactory");
		
		
		  QueueConnection queueConnection = conFactory.createQueueConnection();		  
			  queueConnection.start();	
			  
		   QueueSession queueSession = queueConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		   
		   Queue queue = (Queue) jndi.lookup("MyQueue");	
		   
		   QueueSender queueSender = queueSession.createSender(queue);
		   
		   
		   
		  /* MapMessage mapMessage=queueSession.createMapMessage();
		   mapMessage.setString("a", "aaaa");
		   mapMessage.setInt("v", 111);*/
		   
		   TextMessage message = queueSession.createTextMessage("Hello World!");
		    
		    
		   queueSender.send(message);
		   
		   //System.out.println("Sent message '" + message.getText() + "'");
		   queueConnection.close();
		   


	}

}
