package com.way2learnonline.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.way2learnonline.domain.Order;

@Service
public class OrderProcessServiceImpl  implements OrderProcessService{

	private Map<String, Order> ordersMap= new HashMap<String,Order>();

	public String processOrder(Order order)  {		
		
		String orderId=(int)(Math.random()*10000)+"";
		System.out.println("Processing order ....Order Id : "+orderId);
		ordersMap.put(orderId, order);		
		return orderId;
	}
	
	public List<Order> getAllOrders(){
		System.out.println("Getting all orders....");
		return new ArrayList<Order>(ordersMap.values());
	}
	

	public boolean cancelOrder(String orderId) {
		System.out.println("Cancelling order with order id  : "+orderId);
		
		Order order=ordersMap.remove(orderId);
		
		return true;
	}

}
