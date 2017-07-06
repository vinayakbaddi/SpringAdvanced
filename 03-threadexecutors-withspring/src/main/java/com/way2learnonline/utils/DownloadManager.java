package com.way2learnonline.utils;

import java.util.Date;

public class DownloadManager {
	
	public static void download(String url){
		//System.out.println(Thread.currentThread().getName()+" is Downloading "+url);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" has  Downloaded "+url + "at" +new Date());
	}

}
