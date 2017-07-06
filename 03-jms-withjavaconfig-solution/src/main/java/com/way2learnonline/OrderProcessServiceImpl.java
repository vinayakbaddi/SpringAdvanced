package com.way2learnonline;


import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;



@Component
public class OrderProcessServiceImpl   {  
	
	private Map<String, Order> ordersMap= new HashMap<String,Order>();
	
	@JmsListener(destination="orders")
	@SendTo("processedorderids")
	public OrderConfirmation processOrder(Order order) throws Exception  {	
		
		
		String orderId=(int)(Math.random()*2000)+"";
		System.err.println("Processing order1 ....Order Id : "+orderId+"   "+Thread.currentThread().getName());
		ordersMap.put(orderId, order);			
		
		return new OrderConfirmation(orderId);
		
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

