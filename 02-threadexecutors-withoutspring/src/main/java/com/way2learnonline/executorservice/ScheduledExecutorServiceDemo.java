package com.way2learnonline.executorservice;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService= new ScheduledThreadPoolExecutor(1);
		 Runnable worker = new CountRunnable("CountWork ",1000 );
		 
	//	scheduledExecutorService.scheduleAtFixedRate(worker, 3, 5, TimeUnit.SECONDS);
		 
		//scheduledExecutorService.schedule(worker, 10, TimeUnit.SECONDS);
		 
		 scheduledExecutorService.scheduleWithFixedDelay(worker, 3, 5, TimeUnit.SECONDS);
		 scheduledExecutorService.scheduleAtFixedRate(worker, 3, 5, TimeUnit.SECONDS);
		 //scheduledExecutorService.schedule(command, delay, unit)
		 /*scheduledExecutorService.scheduleWithFixedDelay(worker, 3, 5, TimeUnit.SECONDS);
		 scheduledExecutorService.scheduleWithFixedDelay(worker, 3, 5, TimeUnit.SECONDS);
		 scheduledExecutorService.scheduleWithFixedDelay(worker, 3, 5, TimeUnit.SECONDS);*/
		 
		 System.out.println("Exiting Main");
		
	}

}
