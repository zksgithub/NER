package com.zhangkui.www.graphic.vexsedges;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import com.zhangkui.www.util.io.FileReadWrite;

public class GetVexsAndEdges {
	/**
	 * 获取hash表
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static HashMap<String, Integer> getHashMap(String filename) throws IOException {
		String words = new FileReadWrite().readFile(filename);
		// 去除空格
		words = words.replace(" ", "").replace(" ", "");
		// key + 计数
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (int i = 0; i < words.length(); i++) {
			String word = words.charAt(i) + "";
			int j = 0;
			if (hm.containsKey(word))
				j = (hm.get(word)) + 1;
			hm.put(word + "", j);
		}
		return hm;
	}
	/**
	 * 从文件得到顶点信息
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static char[] getWordVexsArray(String filename) throws IOException {
		HashMap<String, Integer> hm = getHashMap(filename);

		Iterator<String> it = hm.keySet().iterator();
		String total = "";
		while (it.hasNext()) {
			String key = (String) it.next();
			total += key;
		}
		
		System.out.println(total);
		return total.toCharArray();

	}
	/**
	 * 从文件得到边的数据
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static char[][] getWordEdgesArray(String filename) throws IOException {
		String words = new FileReadWrite().readFile(filename);
		// 去除空格
		words = words.replace(" ", "");
		
		char[][] wordsEdges = new char[words.length()][2];
		for (int i = 0; i < words.length() - 1; i++) {
			wordsEdges[i][0] = words.charAt(i);
			wordsEdges[i][1] = words.charAt(i + 1);

		}
		return wordsEdges;

	}

}
