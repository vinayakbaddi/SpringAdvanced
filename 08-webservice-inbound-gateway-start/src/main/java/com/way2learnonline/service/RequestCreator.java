package com.way2learnonline.service;

import com.way2learnonline.domain.Order;
import com.way2learnonline.domain.ProcessOrderRequest;

public class RequestCreator {
	
	public ProcessOrderRequest createRequest(){
		Order order= new Order();
		order.setCustomerID("1111");
		order.setItemID("2222");
		order.setPrice(1222.3);
		
		ProcessOrderRequest request= new ProcessOrderRequest();
		request.setOrder(order);
		
		return request;
	}

}
