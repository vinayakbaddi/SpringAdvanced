package com.way2learnonline.tasks;

import com.way2learnonline.utils.DownloadManager;

public class DownloadTask  implements Runnable{
	
	private String url;
	
	

	public DownloadTask(String url) {
		super();
		this.url = url;
	}



	@Override
	public void run() {
		DownloadManager.download(url);
		
	}

}
