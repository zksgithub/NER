package com.zhangkui.www.util.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadWrite {
	
	public String readFile(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		String data = null;
		StringBuffer stringFromFile = new StringBuffer();
		/**
		//数据按格式
		//数
		//据
		//按
		//这种方式返回
		while((data = br.readLine())!=null)
		{
		System.out.println(data); 
		for(int i=0;i<data.length();i++){
			stringFromFile.append(data.charAt(i)+"\n");
		}		
		}
		*/
		//直接返回
		while((data = br.readLine())!=null){
			stringFromFile.append(data);
		}
		return stringFromFile.toString();
	}
	
	public void writeFile(String filename,String data) throws IOException{
		FileWriter  out = new FileWriter(filename);
		out.write(data);
		out.close();
	}
	
	public void convertFile(String fromFilename,String toFilename) throws IOException{
		String tmp = readFile(fromFilename);
		writeFile(toFilename,tmp);
	}
	

}
