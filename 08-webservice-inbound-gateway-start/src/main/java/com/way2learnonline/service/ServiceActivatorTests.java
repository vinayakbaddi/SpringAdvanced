package com.way2learnonline.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ServiceActivatorTests {
	
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("integration-beans.xml");
		/*MessageChannel messageChannel=context.getBean("orders-channel",MessageChannel.class);
		
		Order order= new Order();
		order.setCustomerID("1111");
		order.setItemID("2222");
		order.setPrice(1222.3);
		
		ProcessOrderRequest request= new ProcessOrderRequest();
		request.setOrder(order);
		 
		
		
		Message<ProcessOrderRequest> orderMessage= MessageBuilder.withPayload(request).build();
		
		
		messageChannel.send(orderMessage);*/
		//messageChannel.send(orderMessage);
		//messageChannel.send(orderMessage);
		
		System.out.println("Order Sent");
	}

}
