package com.way2learnonline;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class ASyncMailer {
	
	@Async
	public void sendMail(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new Date() +"Sending mail....."+Thread.currentThread().getName());
	}
	
	@Async
	public Future<String> sendMailAndReturn(){
		System.out.println(new Date() +"inside sendMailAndReturn....."+Thread.currentThread().getName());
		
		return new AsyncResult<String>("Test result ...");
	}

}
