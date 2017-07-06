package com.way2learnonline.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;





public class ExecutorServiceDemoUsingCallable {

	public static void main(String[] args) {
		 ExecutorService executor = Executors.newFixedThreadPool(10);
		 
		 
		    List<Future<Long>> list = new ArrayList<Future<Long>>();
		    for (int i = 0; i < 20000; i++) {
		      Callable<Long> worker = new MyCallable();
		      Future<Long> submit = executor.submit(worker);
		      list.add(submit);
		    }
		    long sum = 0;
		    System.out.println(list.size());
		    //
		    //
		    // Now retrieve the result
		    for (Future<Long> future : list) {
		      try {
		    	  
		        sum += future.get();
		      } catch (Exception e) {
		        e.printStackTrace();
		      } 
		    }
		    
		    System.out.println(sum);
		    executor.shutdown();

	}

}
