/**
 * 测试所建立的网是否具有自动给出词的能力
 */
package com.zhangkui.www.automaticwordgenerater.testgetword;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.zhangkui.www.automaticwordgenerater.newTech.MyApp;
import com.zhangkui.www.graphic.Graphic;
import com.zhangkui.www.graphic.bean.VetexBean;

import junit.framework.TestCase;

/**
 * @author kuizhang
 *
 */
public class GetWordV2 extends TestCase {
	private int matrix [][];
	private char vexs [];
	private static Logger logger = Logger.getLogger(GetWordV2.class);
	
	public void testGetWordV2() throws ClassNotFoundException, IOException{
		String filename = "target/matrix10.data";
		 Graphic graphic = new Graphic(filename);
		 
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 matrix = graphic.getMatrix();
		 vexs =  graphic.getVexs();
		
		 for(int i=0;i<matrix.length;i++){
				 if(getInList(i).size()==getOutList(i).size()){
					 
					 logger.info(vexs[i]);
					 
				 }
		 }
		// logger.info(vexs[index]+" max="+max+" i="+index);
	}
	/**
	 * 递归寻找下一个节点，但问题在于，这下一条节点，不一定是真正的下一个节点
	 * @param j
	 */
	public void getNext(int j){
		for(int k=0;k<matrix.length;k++){
			if(matrix[j][k]>0){
				System.out.print(vexs[k]);
				matrix[j][k]-=1;
				getNext(k);
			}
		}
		System.out.println("一句话--------------------------");
	}
	/**
	 * 获取某个节点的出口列表
	 * @param j
	 * @return
	 */
	public ArrayList<Integer> getOutList(int j){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int k=0;k<matrix.length;k++){
			if(matrix[j][k]>0){
				list.add(k);
			}
		}
		return list;
		
	}
	/**
	 * 获取某个节点的入口列表
	 * @param j
	 * @return
	 */
	public ArrayList<Integer> getInList(int j){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int k=0;k<matrix.length;k++){
			if(matrix[k][j]>0){
				list.add(k);
			}
		}
		return list;
		
	}
	/**
	 * 计算行（true）和或者列（false）和
	 * 
	 * @param i
	 * @param bool
	 * @return
	 */
	public int getTotal(int i,boolean bool){
		int result = 0;
		
		if(bool){		
		for(int k=0;k<matrix.length;k++){
			result += matrix[i][k];
			}//行和
		}
		else{		
		for(int k=0;k<matrix.length;k++){
				result += matrix[k][i];
			}//列和
		}
		return result;
	}


}
