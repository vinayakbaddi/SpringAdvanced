package com.way2learnonline.executorservice;

import java.util.Date;

public class CountRunnable implements Runnable {
	
	private int n;	

	public CountRunnable(String name,int n) {
		this.n = n;
	
	}

	public void run() {
		
		int sum=0;
		for(int i=1;i<=n;i++){
			sum=sum+i;
		}
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		Thread currentThread=Thread.currentThread();
		System.out.println(currentThread.getName()+"    SUM="+sum +new Date());

	}

	
}
