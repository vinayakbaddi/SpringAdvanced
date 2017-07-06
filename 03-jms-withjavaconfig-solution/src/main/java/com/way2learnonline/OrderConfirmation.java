package com.way2learnonline;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orderConfirmation")
public class OrderConfirmation {

	private String orderId;
	
	public OrderConfirmation() {
		// TODO Auto-generated constructor stub
	}

	public OrderConfirmation(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
