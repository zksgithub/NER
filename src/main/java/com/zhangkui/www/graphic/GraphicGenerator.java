package com.zhangkui.www.graphic;
/**
 * Java: 邻接矩阵图
 *
 * @author zhangkui	
 * @date 2016/04/12	
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GraphicGenerator {

	
    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵

   

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public GraphicGenerator(char[] vexs, char[][] edges) {
        
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);
            
            if(p1==-1|p2==-1) 
            	continue;
            
            mMatrix[p1][p2] += 1;
        }
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch)
                return i;
        return -1;
    }

   

    /*
     * 存储为txt文件
     */
    public void printToText(String filename) throws IOException {
    	
        System.out.println("Martix Graph:\n");
        File file = new File(filename);
        FileWriter fw = new FileWriter(file,true); //设置成true就是追加
        
        for (int i = 0; i < mVexs.length; i++) {
        	 
            for (int j = 0; j < mVexs.length; j++)
            {
            	              
                 fw.write(mMatrix[i][j]+"   ");
                 
            }
            fw.write("\r\n");
            
        }
        fw.close();
    }
    
    public void storeGrapic(String filename) throws IOException{
    	
    	Graphic gf = new Graphic(mVexs,mMatrix);
    	gf.storeGrapic(filename);
    	
    }
    
    
}