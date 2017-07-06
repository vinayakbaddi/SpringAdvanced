package com.way2learnonline.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.way2learnonline.domain.Order;


public class GateWayProxyDemo {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context= new ClassPathXmlApplicationContext("02using-gateway-proxy.xml");
		
		Order order= new Order();
		order.setCustomerID("1111");
		order.setItemID("2222");
		order.setPrice(1222.3);
		order.setQty(22);
		
		OrderProcessService orderProcessService=context.getBean("ops",OrderProcessService.class);
		
		String orderId=orderProcessService.po(order);
		
		System.out.println("Got Order Id : "+orderId);
		
		
		
	}

}
