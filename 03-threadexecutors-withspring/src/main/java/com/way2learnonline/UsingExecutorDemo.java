package com.way2learnonline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

import com.way2learnonline.tasks.DownloadTask;

public class UsingExecutorDemo {

	public static void main(String[] args) {
		ApplicationContext context= 
				new ClassPathXmlApplicationContext("01executors.xml");
		
		TaskExecutor taskExecutor=(TaskExecutor) context.getBean("executor");		
		
		for(int i=0;i<10;i++){
			taskExecutor.execute(new DownloadTask("photourl"+i));			
			System.out.println("Submitted : "+i);
		}
		
		

	}

}
