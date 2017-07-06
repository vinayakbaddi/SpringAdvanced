package com.way2learnonline.service;

import java.util.List;

import com.way2learnonline.domain.Order;




	public interface OrderProcessService {	
		public String processOrder(Order order);		
		public boolean cancelOrder(String orderId);
		public List<Order> getAllOrders();						
	}
	
	
	
	




