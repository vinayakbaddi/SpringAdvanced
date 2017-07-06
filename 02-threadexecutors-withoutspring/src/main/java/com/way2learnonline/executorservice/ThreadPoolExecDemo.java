package com.way2learnonline.executorservice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ThreadPoolExecDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
	/*	ThreadPoolExecutor poolExecutor= 
				new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, 
						new ArrayBlockingQueue<Runnable>(3),new MyRejectionExecutionHandler());*/
		
		ThreadPoolExecutor poolExecutor= 
				new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, 
						new ArrayBlockingQueue<Runnable>(2));
//		
		
		
		for(int i=0;i<20;i++){
			poolExecutor.execute(new CountRunnable("Count"+i, i));
		}
		
		
		
		poolExecutor.shutdown();
		
		poolExecutor.awaitTermination(60, TimeUnit.SECONDS);
		System.out.println("In Main");
		

	}

}
