package com.way2learnonline.batch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.core.io.Resource;



public class ProductReader implements ItemReader<Product>,ItemStream{
	
	private Resource resource;
	
	private BufferedReader reader;
	private ExecutionContext executionContext;
	int filePosition=0;
	int currentPosition=0;
	
	@PostConstruct
	public void initialize() throws Exception{
		reader= new BufferedReader(new FileReader(resource.getFile()));
		reader.readLine();
		filePosition++;
	}	
	
	public Product read() throws Exception{
		String line=reader.readLine();	
		
		while(++currentPosition<filePosition){
			line=reader.readLine();
		}
		
		System.out.println(line);
		
		/*if(filePosition==5){
			throw new RuntimeException("Just for testing");
		}*/
		
		
		
	
		if(line!=null){
			
			String[]fields=	line.split(",");
			Product product= new Product();
			product.setId(fields[0]);
			product.setName(fields[1]);
			product.setDescription(fields[2]);
			product.setPrice(new BigDecimal(fields[3]));
			filePosition++;
			//executionContext.put("position", ++filePosition);
			return product;
		}
		return null;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}


	
	  
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		this.filePosition=executionContext.getInt("position",1);
		
	}




	public void update(ExecutionContext executionContext) throws ItemStreamException {
		executionContext.put("position", filePosition);
		
		System.err.println("Chunk Commited . File Position :  "+filePosition);
		
	}
	

	  public void close() throws ItemStreamException {
		// TODO Auto-generated method stub
		
	}

	
	/*@BeforeStep
	public void beforeStep( StepExecution stepExecution){
		this.executionContext=stepExecution.getExecutionContext();
		this.filePosition=executionContext.getInt("position",1);
	}*/
	
	

}
