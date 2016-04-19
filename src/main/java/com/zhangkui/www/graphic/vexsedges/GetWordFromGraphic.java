package com.zhangkui.www.graphic.vexsedges;

import java.io.IOException;

import com.zhangkui.www.graphic.Graphic;



public class GetWordFromGraphic {
	
	
	public static String getWord(String filename,int pos1,int pos2) throws ClassNotFoundException, IOException{
		 
		 Graphic graphic = new Graphic(filename);
			
		 return graphic.getWord(pos1,pos2); 
	}

}
