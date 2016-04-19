package com.zhangkui.www.graphic.bean;

public class VetexBean implements Comparable<Object>{
	private String vex;
	private int weight;
	
	
	public VetexBean(String vex, int weight) {
		super();
		this.vex = vex;
		this.weight = weight;
	}


	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		VetexBean vetexBean = (VetexBean) arg0;
		
		int result = weight<vetexBean.weight?1:(weight == vetexBean.weight ? 0 : -1);
		if(result ==0){
			result = vex.compareTo(vetexBean.vex);
		}
		return result;
	}
	 public String toString() {
	        return "权重：" + weight + "\t\t字符：" + vex;
	    }

}
