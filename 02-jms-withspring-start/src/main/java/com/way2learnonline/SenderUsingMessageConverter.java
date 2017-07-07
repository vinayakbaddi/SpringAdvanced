package com.way2learnonline;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.PlatformTransactionManager;

public class SenderUsingMessageConverter {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("jms.xml");
		
		
		JmsTemplate jmsTemplate=(JmsTemplate)context.getBean("jmsTemplate");	
		
		//Queue queue=(Queue)context.getBean("tq");
		

		
		//TODO-5 Use JMS template to Convert String "Hello" to TextMessage and send to default destination
		
		// TODO-6 Use JMS template to Convert String "Hello" to TextMessage
		//and send to queue bean with name tq in the configuration
		
		//TODO-7 Use JMS template to Convert String "Hello" to TextMessage
		//and send to queue with jndiname  name testq . Note that this should be using destination resolver
		
		
		context.close();

	}

}
