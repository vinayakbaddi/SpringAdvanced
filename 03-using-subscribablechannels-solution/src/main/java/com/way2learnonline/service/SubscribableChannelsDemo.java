package com.way2learnonline.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.way2learnonline.domain.Order;


public class SubscribableChannelsDemo {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("03-subscribable-channels-demo.xml");
		
		Order order= new Order();
		order.setCustomerID("1111");
		order.setItemID("2222");
		order.setPrice(1222.3);
		order.setQty(22);
		
		Message<Order> orderMessage= 
				MessageBuilder.withPayload(order)
							.build();
		
		MessageChannel messageChannel=
				context.getBean("orderschannel",MessageChannel.class);
		
		messageChannel.send(orderMessage);
		System.out.println("Sent 1");
		/*messageChannel.send(orderMessage);
		System.out.println("Sent 2");
		messageChannel.send(orderMessage);
		System.out.println("Sent 3");
		messageChannel.send(orderMessage);
		System.out.println("Sent 4");
		
		messageChannel.send(orderMessage);
		System.out.println("Sent 5");*/
	
		
	}

}
