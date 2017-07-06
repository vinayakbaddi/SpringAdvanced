package com.way2learnonline.executorservice;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejectionExecutionHandler implements RejectedExecutionHandler {

	
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

executor.execute(r);

	}

	

}
