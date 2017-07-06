package com.way2learnonline;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicPublisherDemo {

	public static void main(String[] args) throws  Exception {
		InitialContext jndi = new InitialContext();		  
		TopicConnectionFactory conFactory = (TopicConnectionFactory) jndi.lookup("connectionFactory");
		  TopicConnection  topicConnection = conFactory.createTopicConnection();		  
		  topicConnection.start();	
		 TopicSession topicSession= topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		  
		   
		   Topic topic = (Topic) jndi.lookup("MyTopic");	
		   
		  TopicPublisher topicPublisher= topicSession.createPublisher(topic);		  
		  
		    TextMessage message = topicSession.createTextMessage("Hello World!");
		 topicPublisher.publish(message);
		   System.out.println("published  message '" + message.getText() + "'");
		   
		   topicSession.close();
		   topicConnection.close();

	}

}
