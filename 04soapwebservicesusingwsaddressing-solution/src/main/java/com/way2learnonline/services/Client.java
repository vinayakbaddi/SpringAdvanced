package com.way2learnonline.services;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;

import javax.xml.transform.TransformerException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.addressing.client.ActionCallback;

import com.way2learnonline.domain.Order;
import com.way2learnonline.domain.ProcessOrderRequest;
import com.way2learnonline.domain.ProcessOrderResponse;



public class Client {

	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("client-config.xml");
		WebServiceTemplate webServiceTemplate=context.getBean(WebServiceTemplate.class);
		
		Order order= new Order();
		order.setCustomerID("12345");
		order.setItemID("2222");
		order.setPrice(1000);
		order.setQty(new BigInteger("5555"));
		
		ProcessOrderRequest requestPayload= new ProcessOrderRequest();
		requestPayload.setOrder(order);
		
		ProcessOrderResponse response=
				(ProcessOrderResponse)webServiceTemplate.
				marshalSendAndReceive(requestPayload,new ActionCallback("http://processOrderaction"));
		
		System.out.println("Got Order ID :"+response.getOrderId());
		context.close();

	}

}
