package com.briup.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class JSQTest extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JPanel north,center;
	private JTextField field;
	private JButton[] btns;
	private String[] str;
	
	private ScriptEngine engine; 
	
	private Timer timer;
	private Date now;
	private SimpleDateFormat sdf;
	
	public JSQTest() {
		setTitle("计算器");
		setSize(700, 700);
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getWidth())/2, (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getHeight())/2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponent();
		setVisible(true);
	}
	private void initComponent(){
		//初始化组件
		north = new JPanel();
		center = new JPanel();
		
		field = new JTextField();
		field.setPreferredSize(new Dimension(700, 40));
		field.setFont(new Font("SansSerif", Font.BOLD, 25));
		field.setEditable(false);
		
		
		str = new String[]{
				"7","8","9","+",
				"4","5","6","-",
				"1","2","3","×",
				"0",".","=","÷",
				"C","B","T","S"
		};
		btns = new JButton[20];
		for(int i=0;i<btns.length;i++){
			btns[i] = new JButton(str[i]);
			btns[i].setFont(new Font("SansSerif", Font.BOLD, 25));
		}
		
		//设置布局管理器并且添加组件
		north.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(5, 4));
		
		north.add(field);
		for(int i=0;i<btns.length;i++){
			center.add(btns[i]);
		}
		
		this.add(north,BorderLayout.NORTH);
		this.add(center);
		
		ScriptEngineManager manager = new ScriptEngineManager();
		engine = manager.getEngineByName("javascript");
		
		
		//添加事件监听器
		for(int i=0;i<btns.length;i++){
			btns[i].addActionListener(this);
		}
		
		
		sdf = new SimpleDateFormat("hh:mm:ss");
		timer = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				now = new Date();
				field.setText(sdf.format(now));
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JButton){
			JButton btn = (JButton) source;
			String btnStr = btn.getText();
			this.append(field, btnStr);
		}
	}
	
	private void append(JTextField field,String btnStr){
		if("=".equals(btnStr)){
			setResultForJTextField(field, btnStr);
		}
		else if("C".equals(btnStr)){
			field.setText("");
		}
		else if("B".equals(btnStr)){
			if("".equals(field.getText())){
				return;
			}
			field.setText(field.getText().substring(0,field.getText().length()-1));
		}
		else if("T".equals(btnStr)){
			timer.start();
		}
		else if("S".equals(btnStr)){
			timer.stop();
			field.setText("");
		}
		else{
			field.setText(field.getText()+btnStr);
		}
	}
	private void setResultForJTextField(JTextField field,String str){
		String result = "";
		try {
			String text = field.getText();
			text = text.replaceAll("×", "*").replaceAll("÷", "/");
			Double d = (Double)engine.eval(text);
			result = d.doubleValue()+"";
		} catch (Exception e) {
			e.printStackTrace();
		}
		field.setText(result);
	}
	
	
	
	public static void main(String[] args) {
		new JSQTest();
	}
}
