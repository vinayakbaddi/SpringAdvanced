package com.way2learnonline.tasks;

import org.springframework.scheduling.annotation.Scheduled;

import com.way2learnonline.utils.DownloadManager;

public class SimpleDownloadTask {
	
	@Scheduled(fixedRate=1000)
	public void downloadFile(){
		DownloadManager.download("Some Url");
	}

}
