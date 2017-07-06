package com.way2learnonline;

import java.util.List;

import org.springframework.batch.item.ItemWriter;



public class CustomWriter implements ItemWriter<Report> {

	
	public void write(List<? extends Report> items) throws Exception {

		System.out.println("writer..." + items.size());		
		for(Report item : items){
			System.out.println(item);
		}

	}

}