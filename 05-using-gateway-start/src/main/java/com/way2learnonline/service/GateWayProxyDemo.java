package com.way2learnonline.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

import com.way2learnonline.domain.Order;


public class GateWayProxyDemo {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context= new ClassPathXmlApplicationContext("02using-gateway-proxy.xml");
		
		Order order= new Order();
		order.setCustomerID("1111");
		order.setItemID("2222");
		order.setPrice(1222.3);
		order.setQty(22);
		
		
		//Message<Order> orderMessage= MessageBuilder.withPayload(order).setReplyChannelName("myreplyChannel").build();
		
		MessageChannel messageChannel=context.getBean("orderschannel",MessageChannel.class);
		
		//messageChannel.send(orderMessage);
		System.out.println("Sent 1");
		
		OrderProcessService orderProcessService=context.getBean("ops",OrderProcessService.class);
		String orderId=orderProcessService.xyzzzzz(order);  
		System.out.println("Got Order Id : "+orderId); 
		
		/*OrderProcessService orderProcessService=context.getBean("orderProcessGateWay",OrderProcessService.class);
		
		String returnValue=orderProcessService.processOrder(order);
		System.out.println("Return Value : "+returnValue);*/
		
/*	*/
		
		
		
/*		messageChannel.send(orderMessage);
		System.out.println("Sent 2");
		messageChannel.send(orderMessage);
		System.out.println("Sent 3");
		messageChannel.send(orderMessage);
		System.out.println("Sent 4");*/
		
	}

}
