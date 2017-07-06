package com.way2learnonline;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class MyTask {
	
	private final long countUntil;	
	
	public MyTask(long countUntil) {
		super();
		this.countUntil = countUntil;
	}

	
	@Scheduled(fixedDelay=5000)
	public void doSomeThing(){
		  long sum = 0;
		    for (long i = 1; i < countUntil; i++) {
		      sum += i;
		    }		 
		    System.out.println(new Date()+"  "+Thread.currentThread().getName() +" : SUM = "+sum);	  
	}

}
