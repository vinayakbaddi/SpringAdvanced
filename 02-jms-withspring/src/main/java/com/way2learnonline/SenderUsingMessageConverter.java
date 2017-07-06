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
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("mailId", "sivaprasad.valluru@gmail.com");
		map.put("country", "India");
		map.put("weight",2.5);
		
		jmsTemplate.convertAndSend("AAAAAAA");
		
		jmsTemplate.convertAndSend("testq",map);
		
		context.close();

	}

}
