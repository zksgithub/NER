package com.zhangkui.www.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import com.zhangkui.www.util.io.FileReadWrite;



public class GetWordHashMap {
		/**
		 * 用hashmap得到文件中的唯一字符
		 * @param filename
		 * @return
		 * @throws IOException
		 */
		private static HashMap<String, Integer> getHashMap(String filename) throws IOException{
		String words = new FileReadWrite().readFile(filename);
		//去除空格
		words = words.replace(" ", "");
		//key + 计数
		HashMap<String,Integer> hm = new HashMap<String, Integer>();	
		for(int i =0 ;i< words.length();i++){
			String word = words.charAt(i)+"";
			int j=0;
			if(hm.containsKey(word))
			 j= (hm.get(word))+1;
			hm.put(word+"", j);
		}
		return hm;
		}
		/**
		 * 将文件中涉及的字符（hashmap保证其 唯一）全取出来，形成图的顶点
		 * @param filename
		 * @return
		 * @throws IOException
		 */
		public static char[] getWordVexsArray(String filename) throws IOException{
			HashMap<String,Integer> hm = getHashMap(filename);		
			Iterator<String> it = hm.keySet().iterator();  
			String total="";
		       while(it.hasNext()) { 	    	
		            String key = (String)it.next();  
		            total+=key;
		        }
		       System.out.println(total);
		       return  total.toCharArray();			
		}
		/**
		 * 将文章中词两两截断，作为图的边，
		 * 如“老科学家年表”
		 * 切为：“老科”，“科学”，“学家”，“家年”，“年表”
		 * @param filename
		 * @return
		 * @throws IOException
		 */
		public static char [][] getWordEdgesArray(String filename) throws IOException{
			String words = new FileReadWrite().readFile(filename);
			//去除空格
			words = words.replace(" ", "");			
			char [][] wordsEdges = new char[words.length()][2];
			for(int i=0;i<words.length()-1;i++){
				wordsEdges[i][0]=words.charAt(i);
				wordsEdges[i][1]=words.charAt(i+1);
			}
			return wordsEdges;				
		}

}
