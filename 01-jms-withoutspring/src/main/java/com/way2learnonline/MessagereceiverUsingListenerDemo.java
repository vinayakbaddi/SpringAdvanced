package com.way2learnonline;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessagereceiverUsingListenerDemo {

	public static void main(String[] args) throws Exception {
		//InitialContext jndi = new InitialContext();		  
		QueueConnectionFactory conFactory = (QueueConnectionFactory) new ActiveMQConnectionFactory("tcp://localhost:61616");
		  QueueConnection queueConnection = conFactory.createQueueConnection();		  
			 		   
		   QueueSession queueSession = queueConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		   Queue queue = queueSession.createQueue("vmwareq");
		   QueueReceiver queueReceiver= queueSession.createReceiver(queue);
		 
		   
		   queueReceiver.setMessageListener(new MessageListener() {
			
			
			public void onMessage(Message message) {
				TextMessage textMessage=(TextMessage) message;
				  try {
					System.out.println(Thread.currentThread().getName()+"   Received : "+textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		   
		   
		  
		  
		 
		   
		  		 
		   queueConnection.start();
		  
	}

}
