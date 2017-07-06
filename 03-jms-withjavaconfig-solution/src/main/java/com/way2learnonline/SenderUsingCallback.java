package com.way2learnonline;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.way2learnonline.config.JmsConfig;


public class SenderUsingCallback {

	public static void main(String[] args) {
		
		ApplicationContext context= new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jmsTemplate=(JmsTemplate)context.getBean(JmsTemplate.class);
		;
		/*Map<String, String> map= new HashMap<String, String>();
		map.put("mailId", "sivaprasad.valluru@gmail.com");
		map.put("country", "India");
		map.put("weight", "2.5");
		*/
		
				
		jmsTemplate.send(new MessageCreator() {

			
			public Message createMessage(Session session) throws JMSException {
				
		
				Message message=session.createTextMessage("AAAAAAAAAAAAAAAAAAa");
				//message.set
				
				
				
				
				return message;
				
			}
		});
	}

}
