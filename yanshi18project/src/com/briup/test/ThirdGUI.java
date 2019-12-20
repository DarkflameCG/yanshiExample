package com.briup.test;

import java.awt.*;


//多个布局管理器
public class ThirdGUI {
	public static void main(String[] args) {
		Frame f = new Frame("布局管理器");
		f.setSize(800, 500);
		
		TextField t = new TextField();
		
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,4));
		

		//添加控件到容器里
		f.add(p,BorderLayout.CENTER);
		f.add(t,BorderLayout.NORTH);
		//循环创建16个button
		for(int i=0;i<16;i++) {
			Button b = new Button(String.valueOf(i+1));
			p.add(b);
		}
		
		f.setVisible(true) ;
	}
}
