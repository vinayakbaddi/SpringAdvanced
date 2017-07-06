package com.way2learnonline.executorservice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {


	public Long call() throws Exception {
		long sum = 0;
	    for (long i = 0; i <= 100; i++) {
	      sum += i;
	    }
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println(Thread.currentThread().getName() +" : SUM = "+sum);
	    return sum;
	}

}
