package com.way2learnonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.way2learnonline.domain.Order;
import com.way2learnonline.domain.ProcessOrderRequest;
import com.way2learnonline.domain.ProcessOrderResponse;

@Endpoint
public class OrderProcessEndpoint {
	
	@Autowired private OrderProcessService orderProcessService;
	
	@PayloadRoot(localPart="processOrderRequest",namespace="http://domain.way2learnonline.com")
	public @ResponsePayload  ProcessOrderResponse 
	processOrder( @RequestPayload ProcessOrderRequest request){
		
		Order order=request.getOrder();
		
		String orderId=orderProcessService.processOrder(order);
		
		ProcessOrderResponse response= new ProcessOrderResponse();
		response.setOrderId(orderId);
		return response;
		
		
	}

}
