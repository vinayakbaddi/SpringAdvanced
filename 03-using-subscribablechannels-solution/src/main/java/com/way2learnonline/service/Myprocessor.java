package com.way2learnonline.service;

public class Myprocessor {
	
	public void doProcess(Object o) throws Exception{
		System.out.println("Myprocessor.doProcess() "+Thread.currentThread().getName());			
		Thread.sleep(3000);
		
	}

}
