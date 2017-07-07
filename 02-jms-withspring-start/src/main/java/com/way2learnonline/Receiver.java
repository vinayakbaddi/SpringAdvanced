package com.way2learnonline;

import java.util.Map;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.StreamMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Receiver {

	public static void main(String[] args) throws JMSException {
		ApplicationContext context= new ClassPathXmlApplicationContext("jms.xml");
		
		JmsTemplate jmsTemplate=(JmsTemplate)context.getBean("jmsTemplate");
		
		//TODO-8 Use jms template to receive the JMS Message and Convert It .
		//Initialize the below variable with the received data
		
		Object receivedData=null;//jmsTemplate.receiveAndConvert();
		
		System.out.println(receivedData);
		
		// TODO-9 Use JMSTemplate to receive a JMS TextMessage with out converting.
		
	}

}
