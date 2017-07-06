package com.way2learnonline.services;

import java.math.BigInteger;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.way2learnonline.domain.Order;
import com.way2learnonline.domain.ProcessOrderRequest;
import com.way2learnonline.domain.ProcessOrderResponse;

public class Client {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext("client-config.xml");
		WebServiceTemplate webServiceTemplate=context.getBean(WebServiceTemplate.class);
		
		Order order= new Order();
		order.setCustomerID("12345");
		order.setItemID("2222");
		order.setPrice(1000);
		order.setQty(new BigInteger("5555"));
		
		ProcessOrderRequest requestPayload= new ProcessOrderRequest();
		requestPayload.setOrder(order);
		ProcessOrderResponse response=
				(ProcessOrderResponse) webServiceTemplate.marshalSendAndReceive(requestPayload);
		
		System.out.println("Got Order ID :"+response.getOrderId());
		context.close();
		
		
	}

}
