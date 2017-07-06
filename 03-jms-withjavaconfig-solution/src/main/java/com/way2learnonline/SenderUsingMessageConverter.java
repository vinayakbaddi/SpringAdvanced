package com.way2learnonline;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.PlatformTransactionManager;

import com.way2learnonline.config.JmsConfig;


public class SenderUsingMessageConverter {

	
	public static void main(String[] args) throws Throwable {
		ApplicationContext context= new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jmsTemplate=(JmsTemplate)context.getBean(JmsTemplate.class);
	
		Order order= new Order();
		order.setCustomerID("1111");
		order.setItemID("2222");
		order.setPrice(1222.3);
		order.setQty(22);
		
		//Queue queue=(Queue)context.getBean("tq");
		
		/*
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("mailId", "sivaprasad.valluru@gmail.com");
		map.put("country", "India");
		map.put("weight",2.5);*/
		
		jmsTemplate.convertAndSend(order);
		
		//Thread.sleep(10000);
		
		//jmsTemplate.convertAndSend("testq",map);
		
		

	}

}
