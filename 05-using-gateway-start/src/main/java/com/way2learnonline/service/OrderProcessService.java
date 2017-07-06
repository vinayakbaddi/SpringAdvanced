package com.way2learnonline.service;

import java.util.List;
import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.integration.annotation.Gateway;

import com.way2learnonline.domain.Order;




public interface OrderProcessService {



	public String xyzzzzz(Order order) throws Exception;
	
	/*@Gateway(requestChannel="cancelChannel")
	public boolean cancelOrder(String orderId);*/
	
	
					
}




