package com.way2learnonline.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import java.util.concurrent.Future;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.scheduling.annotation.AsyncResult;

import com.way2learnonline.domain.Order;



public class OrderProcessServiceImpl   {  
	
	private Map<String, Order> ordersMap= new HashMap<String,Order>();
	
	
	public void processOrder(Order order) throws Exception  {		
		
		String orderId=(int)(Math.random()*2000)+"";
		System.out.println("Processing order1 ....Order Id : "+orderId+"   "
							+Thread.currentThread().getName());
		ordersMap.put(orderId, order);		
		
	}

	

}

