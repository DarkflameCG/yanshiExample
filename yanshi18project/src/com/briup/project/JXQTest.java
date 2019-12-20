package com.briup.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JXQTest extends JFrame{
	
	private Container container;
	private JPanel panel;
	private JTextField showText;
	private JButton[] btns;
	
	private static final int btnNumb=16;
	private static final String[] source = {"1","2","3","+",
										    "4","5","6","-",
										    "7","8","9","x",
										    "0",".","clear","/"};
	
	public JXQTest() {
		this.setTitle("计算器");
		this.setLocation(350, 30); //如何计算屏幕中点
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = this.getContentPane();
		container.setBackground(Color.CYAN);
		
		init();
		addChild();
		
		this.setVisible(true);
	}
	private void init() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,5,5));
		panel.setBackground(Color.BLACK);
		
		showText=new JTextField();
		btns = new JButton[btnNumb];
		
	}
	private void addChild() {
		
		for(int i = 0; i<btnNumb;i++) {
			btns[i]=new JButton(source[i]);
			panel.add(btns[i]);
		}
		
		container.add(panel,BorderLayout.CENTER);
		container.add(showText,BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args) {
		new JXQTest();
	}
}
