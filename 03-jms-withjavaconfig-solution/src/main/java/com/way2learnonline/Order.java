package com.way2learnonline;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
public class Order implements Serializable {

	
	    protected String customerID;	  
	    protected String itemID;	   
	    protected int qty;
	    protected double price;
	    
	    
		public String getCustomerID() {
			return customerID;
		}
		public void setCustomerID(String customerID) {
			this.customerID = customerID;
		}
		public String getItemID() {
			return itemID;
		}
		public void setItemID(String itemID) {
			this.itemID = itemID;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
	    
	    

}
