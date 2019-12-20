package com.briup.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JXQTest extends JFrame implements ActionListener{
	
	private Container container;
	private JPanel panel;
	private JTextField showText;
	private JButton[] btns;
	private JButton temp;
	
	private static final int btnNumb=20;
	private static final String[] source = {"1","2","3","+",
										    "4","5","6","-",
										    "7","8","9","×",
										    "0",".","C","÷",
										    "T","S","<—","="};
	
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
		
		Font font = new Font("楷体",Font.BOLD,50);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,4,5,5));
		panel.setBackground(Color.BLACK);
		
		showText=new JTextField();
		showText.setFont(font);
		showText.setHorizontalAlignment(4);
		showText.setEditable(false);
		
		btns = new JButton[btnNumb];
		
		
	}
	private void addChild() {
		
		for(int i = 0; i<btnNumb;i++) {
			temp = btns[i];
			temp=new JButton(source[i]);
			temp.setFont(new Font("宋体",1,50));
			temp.setBackground(Color.red);
			
			//判断，哪个是哪个button
			temp.addActionListener(this);
			
			panel.add(temp);
		}
		
		container.add(panel,BorderLayout.CENTER);
		container.add(showText,BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args) {
		new JXQTest();
	}
	
	//最后的计算逻辑  点击等号（=）之后要做的事情
	public void getResult() {
		
	}
	
	//拼接字符串
	public void appendBtnText(JTextField text, String btnStr) {
		if("C".equals(btnStr)) {
			//清除
		}else if ("=".equals(btnStr)) {
			//计算的逻辑
			//可以在此代码块里去写，也可以另起一个方法（推荐）
			this.getResult();
		}else if ("S".equals(btnStr)){
			
		}else if ("T".equals(btnStr)){
			
		}else if ("<—".equals(btnStr)){
			
		}else {
			showText.setText(showText.getText()+btnStr);
		}
		
		
	}
	
	
	@Override //方法重写
	public void actionPerformed(ActionEvent e) {
		//判断当前的事件源是否是button
		Object source = e.getSource();
		if(source instanceof JButton) {
			JButton btn = (JButton)source;
			String btnstr = btn.getText();
			//拼接字符串
			this.appendBtnText(showText,btnstr);
		}
		
		
		
	}
}
