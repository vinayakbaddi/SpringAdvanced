package com.way2learnonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.way2learnonline.domain.CancelOrderRequest;
import com.way2learnonline.domain.CancelOrderResponse;
import com.way2learnonline.domain.GetAllOrdersRequest;
import com.way2learnonline.domain.GetAllOrdersResponse;
import com.way2learnonline.domain.Order;
import com.way2learnonline.domain.ProcessOrderRequest;
import com.way2learnonline.domain.ProcessOrderResponse;

	@Endpoint
	public class OrderProcessEndpoint {
		
		@Autowired private OrderProcessService orderProcessService;
		
		
		@PayloadRoot(localPart="processOrderRequest",namespace="http://domain.way2learnonline.com")
		public @ResponsePayload ProcessOrderResponse processOrder(
						@RequestPayload ProcessOrderRequest processOrderRequest){
			
			Order order=processOrderRequest.getOrder();
			
			String orderId=orderProcessService.processOrder(order);
			
			ProcessOrderResponse processOrderResponse= new ProcessOrderResponse();
			processOrderResponse.setOrderId(orderId);
			
			return processOrderResponse;
			
		}
	
		
		
	@PayloadRoot(localPart="cancelOrderRequest" ,namespace="http://domain.way2learnonline.com")
	public @ResponsePayload CancelOrderResponse cancelOrder
					(@RequestPayload CancelOrderRequest cancelOrderRequest){
		String orderId=cancelOrderRequest.getOrderId();
		
		boolean isCancelled=orderProcessService.cancelOrder(orderId);
		
		CancelOrderResponse cancelOrderResponse= new CancelOrderResponse();
		cancelOrderResponse.setIsCancelled(isCancelled);
		return cancelOrderResponse;
		
	}
	
	@PayloadRoot(localPart="getAllOrdersRequest" ,namespace="http://domain.way2learnonline.com")
	public @ResponsePayload GetAllOrdersResponse
					getAllOrders(@RequestPayload GetAllOrdersRequest getAllOrdersRequest){
		List<Order> orders=orderProcessService.getAllOrders();
		
		GetAllOrdersResponse getAllOrdersResponse=  new GetAllOrdersResponse();
		getAllOrdersResponse.getOrders().addAll(orders);
		
		return getAllOrdersResponse;
	}
	
	
}
