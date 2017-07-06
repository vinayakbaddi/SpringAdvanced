package com.way2learnonline;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/batch/jobs/job-hello-world.xml" );
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("helloWorldJob");

		try {
			
			JobParametersBuilder jobParametersBuilder= new JobParametersBuilder();
			jobParametersBuilder.addString("test", "QQQWW");
			
			

			JobExecution execution = jobLauncher.run(job, jobParametersBuilder.toJobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}
