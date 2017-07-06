package com.way2learnonline;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiverDemo {


	public static void main(String[] args) throws Exception {
		InitialContext jndi = new InitialContext();		  
		
		QueueConnectionFactory conFactory = (QueueConnectionFactory) new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		  QueueConnection queueConnection = conFactory.createQueueConnection();		  
			  queueConnection.start();		   
		   QueueSession queueSession =
				   queueConnection.createQueueSession(true,Session.DUPS_OK_ACKNOWLEDGE);
		   Queue queue = (Queue) jndi.lookup("MyQueue");
				   //queueSession.createQueue("example.MyQueue");
		  QueueReceiver queueReceiver= queueSession.createReceiver(queue); 
		  
		  
		
		  TextMessage textMessage=(TextMessage) queueReceiver.receive();
		  
		  
		  
		  System.out.println("Received : "+textMessage.getText());
		  
		//  textMessage.acknowledge();
		  //textMessage.getJMSRedelivered()
		  
		//  textMessage.acknowledge();
		  
		 queueSession.commit();
		  
		  queueSession.close();
		  queueConnection.close();
		   
	}

}
