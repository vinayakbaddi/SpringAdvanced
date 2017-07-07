package com.way2learnonline.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.way2learnonline.domain.Order;
import com.way2learnonline.domain.ProcessOrderRequest;


public class ServiceActivatorTests {
	
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("inbound-gateway-config.xml");
		MessageChannel messageChannel=context.getBean("orders-channel",MessageChannel.class);
		
		Order order= new Order();
		order.setCustomerID("1111");
		order.setItemID("2222");
		order.setPrice(1222.3);
		
		ProcessOrderRequest request= new ProcessOrderRequest();
		request.setOrder(order);
		 
		
		
		Message<ProcessOrderRequest> orderMessage= MessageBuilder.withPayload(request).build();
		
		
		messageChannel.send(orderMessage);
		//messageChannel.send(orderMessage);
		//messageChannel.send(orderMessage);
		
		System.out.println("Order Sent");
	}

}
