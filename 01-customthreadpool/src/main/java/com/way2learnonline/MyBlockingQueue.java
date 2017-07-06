package com.way2learnonline;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;


 public class MyBlockingQueue {
	 
	private List<Object> queue = new LinkedList<Object>();
	
	  private  int  limit = 10;
	  
	  private Semaphore semaphore;
	  
	  public MyBlockingQueue(int limit){
	    this.limit = limit;
	    semaphore= new Semaphore(limit);
	    
	  }
	  
	  public synchronized void enqueue(Object item)throws InterruptedException  {
	    semaphore.acquire();
	    System.out.println("Adding : "+item);
	    this.queue.add(item);
	  }
	  
	  
	  public synchronized Object dequeue() throws InterruptedException{
		  semaphore.release(); 
	  
	   Object item=this.queue.remove(0);
	   System.out.println("Removing : "+item);
	    return item;
	  }
	  
	  
}
