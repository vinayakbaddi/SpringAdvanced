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
		
		//.out.println("Customer id "+order.getCustomerID());
		String orderId=(int)(Math.random()*2000)+"";
		System.out.println("Processing order1 ....Order Id : "+orderId+"   "+Thread.currentThread().getName());
		ordersMap.put(orderId, order);		
		/*if(true){
			throw new RuntimeException("Just for testing");
		}
		
		Thread.sleep(5000);	
		*/
		
		
		//return orderId;
		//return new AsyncResult<String>(orderId);
	}

	
	
	

	/*public String processOrder(Order order) throws Exception  {	
		
		String orderId=(int)(Math.random()*2000)+"";
		System.out.println("Processing order ....Order Id : "+orderId +Thread.currentThread().getName());
		ordersMap.put(orderId, order);	
		if(true){
			throw new RuntimeException("Just for testing");
		}
		Thread.sleep(2000);
		System.out.println("After Waking up : "+Thread.currentThread().getName());
		return orderId;
	}*/
	
	/*public List<Order> getAllOrders(){
		return new ArrayList<Order>(ordersMap.values());
	}
	

	public boolean cancelOrder(String orderId) {
		System.out.println("Cancelling order with order id  : "+orderId);
		
		Order order=ordersMap.remove(orderId);
		
		return true;
	}*/

}

