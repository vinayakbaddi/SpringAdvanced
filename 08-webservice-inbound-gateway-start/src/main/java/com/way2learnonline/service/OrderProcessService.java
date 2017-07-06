package com.way2learnonline.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.integration.annotation.Splitter;

import com.way2learnonline.domain.Order;




public interface OrderProcessService {

	
	public String processOrder(Order order) throws Exception; 
				
	
	public boolean cancelOrder(String orderId);
	public List<Order> getAllOrders();
					
}




