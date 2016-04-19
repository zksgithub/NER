package com.zhangkui.www.graphic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author kuizhang
 * 定义矩阵的结构，并可以根据所在行和列查询词组
 */
public class Graphic implements Serializable {
	
	private static final long serialVersionUID = 208028480788197681L;
	
	private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    
    
    /**
     * 采用反序列化进行图的初始化
     * @param filename
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Graphic(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
    	FileInputStream fis = new FileInputStream(filename); 
		 
		 ObjectInputStream ois = new ObjectInputStream(fis);  
		 
		 Graphic graphic = (Graphic) ois.readObject();  
		  		   
		 ois.close();  
		 fis.close(); 
		 this.mVexs = graphic.getVexs();
		 this.mMatrix = graphic.getMatrix();
	}
    /**
     * 构造函数，采用顶点和边的邻接矩阵进行定义
     * @param mVexs
     * @param mMatrix
     */
    Graphic(char[] mVexs,int[][] mMatrix){
    	this.mVexs = mVexs;
    	this.mMatrix = mMatrix;
    }

	
    /**
     * 根据邻接矩阵获取字符对
     * @param i
     * @param j
     * @return
     */
    public String getWord(int i,int j){
    	return mVexs[i]+""+mVexs[j]+"";
    }
    /**
     * 序列化存储到本地
     * @param filename
     * @throws IOException
     */
    public void storeGrapic(String filename) throws IOException{
    	
    	Graphic gf = new Graphic(mVexs,mMatrix);
    	File file = new File(filename); 
    	FileOutputStream fos = new FileOutputStream(file);  
    	ObjectOutputStream oos = new ObjectOutputStream(fos);  
    	oos.writeObject(gf);  
    	oos.flush();  
    	oos.close();  
    	fos.close();  
    	
    }
    
    public int[][] getMatrix(){
    	return mMatrix;
    }
    
    public char[] getVexs(){
    	return mVexs;
    }
    
}
