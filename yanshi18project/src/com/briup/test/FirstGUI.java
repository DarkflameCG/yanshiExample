package com.briup.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;

public class FirstGUI {
	public static void main(String[] args) {
		//1、选择容器
		Frame frame = new Frame("第一个程序");
		//取消默认的布局管理器
		//frame.setLayout(new FlowLayout(FlowLayout.LEFT,50,50));
		//网格布局管理器
		frame.setLayout(new GridLayout(2,2,50,50));
		//卡片布局管理器
		//frame.setLayout(new CardLayout());
		
		//2、给容器设置一些宽高 set
		frame.setSize(500,500);
		//修改颜色
		frame.setBackground(new Color(134, 222, 88));
		
		//4、准备一个按钮
		Button button1 = new Button("1");
		Button button2 = new Button("2");
		Button button3 = new Button("3");
		Button button4 = new Button("4");
		//准备一个文本框
		TextField text = new TextField();
		//放入容器内
		//frame.add(text);
		frame.add(button1,BorderLayout.WEST);
		frame.add(button2,BorderLayout.EAST);
		frame.add(button3,BorderLayout.NORTH);
		frame.add(button4,BorderLayout.SOUTH);
		//3、设置容器可见
		frame.setVisible(true);
		
	}
}
