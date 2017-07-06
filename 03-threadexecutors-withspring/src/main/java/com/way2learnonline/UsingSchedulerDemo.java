package com.way2learnonline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.TaskScheduler;

import com.way2learnonline.tasks.DownloadTask;

public class UsingSchedulerDemo {

	public static void main(String[] args) {
		ApplicationContext context= 
				new ClassPathXmlApplicationContext("02scheduler.xml");
		
		TaskScheduler taskScheduler=context.getBean("scheduler",TaskScheduler.class);
		
		taskScheduler.scheduleAtFixedRate(new DownloadTask("someeurl"),5000);
		//taskScheduler.scheduleAtFixedRate(new CountRunnable("AAA", 10), 5000);
		//taskScheduler.scheduleWithFixedDelay(new DownloadTask("someeurl"), 5000);
		//taskScheduler.schedule(new CountRunnable("AAA", 10), new CronTrigger("* 15 9-17 * * MON-FRI"));
		
		
		

	}

}
