package com.zhangkui.www.automaticwordgenerater;

import java.util.logging.Logger;

import com.zhangkui.www.graphic.GraphicGenerator;
import com.zhangkui.www.graphic.vexsedges.GetVexsAndEdges;

import junit.framework.TestCase;

public class Test extends TestCase {
	

	//测试图的生成和存储
	public void testGraphicGenerate() throws Exception{
		String filename ="/Users/zhangkui/Documents/workspace4mars/scientistanlytic/nianbiao/沈克琦.txt";
        char[] vexs = GetVexsAndEdges.getWordVexsArray(filename);
        
        char[][] edges = GetVexsAndEdges.getWordEdgesArray(filename);
        GraphicGenerator pG;
        
       
        pG = new GraphicGenerator(vexs, edges);
        
        
        pG.printToText("matrix10.txt");   // 打印图
        pG.storeGrapic("matrix10.data");
	}
}
