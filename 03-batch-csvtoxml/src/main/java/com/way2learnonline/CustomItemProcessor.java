package com.way2learnonline;

import org.springframework.batch.item.ItemProcessor;



public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	
	public Report process(Report item) throws Exception {
		
		System.out.println("Processing..." + item);
		if(item.getDate()==null){
			throw new Exception("Bad Recordddddddddddddddd");
		}
		return item;
	}

}