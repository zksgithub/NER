package com.zhangkui.www.automaticwordgenerater;

import java.io.IOException;

import com.zhangkui.www.graphic.GraphicGenerator;
import com.zhangkui.www.graphic.vexsedges.GetVexsAndEdges;

/**
 * Hello world!
 *
 */
public class WordGenerator 
{
    public static void main( String[] args ) throws IOException
    {
    	String filename ="nianbiao/沈克琦.txt";
        char[] vexs = GetVexsAndEdges.getWordVexsArray(filename);
        
        char[][] edges = GetVexsAndEdges.getWordEdgesArray(filename);
        GraphicGenerator pG;
        
       
        pG = new GraphicGenerator(vexs, edges);
        
        
        
        
        pG.printToText("target/matrix10.txt");   // 打印图
        pG.storeGrapic("target/matrix10.data");
    }
}
