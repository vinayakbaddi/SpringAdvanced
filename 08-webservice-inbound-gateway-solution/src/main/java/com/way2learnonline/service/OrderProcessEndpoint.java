package com.way2learnonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.way2learnonline.domain.*;



public class OrderProcessEndpoint {
	@Autowired
	private OrderProcessService orderProcessService;
	
	
	public  ProcessOrderResponse processOrder( ProcessOrderRequest processOrderRequest) throws Exception{
		
		Order order= processOrderRequest.getOrder(); 
		String orderId=orderProcessService.processOrder(order);
		ProcessOrderResponse processOrderResponse=new ProcessOrderResponse();
		processOrderResponse.setOrderId(orderId);
		return  processOrderResponse;
	}
	
	
	public  GetAllOrdersResponse getAllOrders( GetAllOrdersRequest getAllOrdersRequest){
		
		
		
		GetAllOrdersResponse response= new GetAllOrdersResponse();
		response.setOrders(orderProcessService.getAllOrders());
		return response;
	}
	


}
