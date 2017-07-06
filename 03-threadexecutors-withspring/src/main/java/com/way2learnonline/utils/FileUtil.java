package com.way2learnonline.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> readFile(String fileName){
		
		List<String> lines= new ArrayList<String>();
		BufferedReader reader=null;
		try {
			
			 reader = new BufferedReader(new FileReader(fileName));
			String line=reader.readLine();
			while(line!=null){
				lines.add(line);
				line=reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Some problem While reading file", e);
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return lines;
	}
}
