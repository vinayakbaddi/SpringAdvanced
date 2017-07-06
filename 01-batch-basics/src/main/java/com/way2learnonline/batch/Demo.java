package com.way2learnonline.batch;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {


	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ApplicationContext context= new ClassPathXmlApplicationContext("batch.xml");
		
		JobLauncher jobLauncher=(JobLauncher) context.getBean("jobLauncher");
		Job job=(Job) context.getBean("importProducts");
		
		
		JobParameters jobParameters= new JobParametersBuilder()
			.addString("inputResource", "classpath:/input/products.zip")
			.addString("targetDirectory", "./target/importproductsbatch4/")
			.addString("targetFile","products.txt")
			//.addLong("timestamp", System.currentTimeMillis())
			.toJobParameters();
		
		JobExecution jobExecution=jobLauncher.run(job,jobParameters);
		
	}

}
