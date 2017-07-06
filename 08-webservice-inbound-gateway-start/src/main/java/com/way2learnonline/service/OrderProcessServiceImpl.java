package com.way2learnonline.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.way2learnonline.domain.Order;





public class OrderProcessServiceImpl implements OrderProcessService {  
	
	private Map<String, Order> ordersMap= new HashMap<String,Order>();

	public String processOrder(Order order) throws Exception  {	
		
		String orderId=(int)(Math.random()*10000)+"";
		System.out.println("Processing order ....Order Id : "+orderId);
		ordersMap.put(orderId, order);		
		Thread.sleep(10000);
		System.out.println("After Waking up : "+Thread.currentThread().getName());
		return orderId;
	}
	
	public List<Order> getAllOrders(){
		return new ArrayList<Order>(ordersMap.values());
	}
	

	public boolean cancelOrder(String orderId) {
		System.out.println("Cancelling order with order id  : "+orderId);
		
		Order order=ordersMap.remove(orderId);
		
		return true;
	}

}

