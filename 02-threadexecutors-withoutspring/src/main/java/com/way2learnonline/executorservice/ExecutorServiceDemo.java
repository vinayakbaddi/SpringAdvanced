package com.way2learnonline.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ExecutorServiceDemo {


	public static void main(String[] args) throws InterruptedException {
		
		 ExecutorService executor = Executors.newCachedThreadPool();
		 //60 secs
		    for (int i = 0; i < 500; i++) {
		      Runnable worker = new CountRunnable(i+"",1000 + i);
		      executor.execute(worker);
		    }
		    
		    // This will make the executor accept no new tasks
		    // and finish all existing threads in the queue
		   executor.shutdown();
	   executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		    
		    System.out.println("Finished all threads");

	}

}
