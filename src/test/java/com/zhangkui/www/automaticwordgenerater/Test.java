package com.zhangkui.www.automaticwordgenerater;

import com.zhangkui.www.graphic.GraphicGenerator;
import com.zhangkui.www.graphic.vexsedges.GetVexsAndEdges;

import junit.framework.TestCase;

public class Test extends TestCase {
	

	//测试图的生成和存储
	public void testGraphicGenerate() throws Exception{
		String filename ="nianbiao/沈克琦.txt";
        char[] vexs = GetVexsAndEdges.getWordVexsArray(filename);
        
        char[][] edges = GetVexsAndEdges.getWordEdgesArray(filename);
     
        
        for(int i =0;i<vexs.length;i++)
        	System.out.print("\'"+vexs[i]+"\'"+",");
        /**
        GraphicGenerator pG;
        pG = new GraphicGenerator(vexs, edges);
        pG.printToText("target/matrix10.txt");   // 打印图
        pG.storeGrapic("target/matrix10.data");
        */
	}
}
