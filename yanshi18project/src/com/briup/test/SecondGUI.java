package com.briup.test;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Label;

public class SecondGUI {
	public static void main(String[] args) {
		Frame frame = new Frame("panel测试");
		frame.setLayout(null);
		frame.setLocation(200,300);
		frame.setSize(500,200);
		//使用panel  小视图
		Panel panel = new Panel();
		panel.setLocation(20,20);
		panel.setSize(200,200);
		panel.setBackground(Color.CYAN);
		
		Panel panel2 = new Panel();
		panel2.setLocation(250, 20);
		panel.setLayout(null);
		panel.setSize(200,200);
		panel.setBackground(Color.RED);
		//准备组件
		TextField text1 = new TextField();
		Label label = new Label("+");
		TextField text2 = new TextField();
		//放组件
		panel.add(text1);
		panel.add(label);
		panel.add(text2);
		frame.add(panel); 
		frame.add(panel2); 
		//设置可见
		frame.setVisible(true);
		
	}
}
