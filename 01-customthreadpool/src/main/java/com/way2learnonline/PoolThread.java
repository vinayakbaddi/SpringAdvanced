package com.way2learnonline;

public class PoolThread extends Thread {

	  private MyBlockingQueue taskQueue = null;
	  private boolean       isStopped = false;

	  public PoolThread(MyBlockingQueue queue){
	    taskQueue = queue;
	  }

	  public void run(){
	    while(!isStopped()){
	      try{
	        Runnable runnable = (Runnable) taskQueue.dequeue();
	        runnable.run();
	      } catch(Exception e){
	        //log or otherwise report exception,
	        //but keep pool thread alive.
	      }
	    }
	  }

	  public synchronized void stopThread(){
	    isStopped = true;
	    //this.interrupt(); //break pool thread out of dequeue() call.
	  }

	  public synchronized boolean isStopped(){
	    return isStopped;
	  }
	}