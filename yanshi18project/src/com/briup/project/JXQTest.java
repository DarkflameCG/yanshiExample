package com.briup.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class JXQTest extends JFrame implements ActionListener{
	
	//将字符串转成对应的表达式
	private ScriptEngine engine;
	
	private static final int btnNumb=20;
	private static final String[] source = {"7","8","9","+",
										    "4","5","6","-",
										    "1","2","3","×",
										    "C","0",".","÷",
										    "T","S","<—","="};
		
	
	private Container container;
	private JPanel panel;
	private JTextField showText;
	private JButton[] btns;
	private JButton temp;
	
	
	//时间工具
	private Timer timer;
	private SimpleDateFormat sdf;
	private Date date;
	
	//标志位
	private boolean flag;
	
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
		
		//初始化组件之外的对象
		sdf = new SimpleDateFormat("HH:mm:ss"); //16:53:29
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("这是个定时器");
				date = new Date(); //代表当前时间的一个日期对象
				showText.setText(sdf.format(date));
			}
		});
		
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
	public void getResult() throws Exception {
		//第一步：准备一个空的结果
		String result = "";
		String old = showText.getText();
		
		//第二步：把字符串转化成对应的表达式  ScritptEngine
		//准备工作，找一个engine对象的管理类  原因：engine是一个接口
		ScriptEngineManager manager = new ScriptEngineManager();
		engine=manager.getEngineByName("javascript");
		//第三步：替换符号  
		String newstr = old.replaceAll("÷", "/").replaceAll("×", "*");
		//第四步：关于类型不同的解决方法
		//知识点
		//System.out.println(0.0/0.0);
		//加个判断，判断old里有没有字符  .
		if(old.indexOf(".")>0) {
			//System.out.println("这是浮点型");
			result = String.valueOf((double)engine.eval(newstr));
			
		}else {
			//System.out.println("这是整型");
			result = String.valueOf((int)engine.eval(newstr));
		}
		
		
		showText.setText(result);
	}
	
	//想去添加的定时器
	public void  startTime() {
		//获取当前时间
		//获取的是时间格式   获取的是时间戳
		//showText.setText(String.valueOf(new Date().getTime()));
		timer.start();
	}

	public void  stopTime() {
		timer.stop();
	}
	
	//拼接字符串
	public void appendBtnText(JTextField text, String btnStr) {
		if("C".equals(btnStr)) {
			//清除
			showText.setText("");
		}else if ("=".equals(btnStr)) {
			//计算的逻辑
			//可以在此代码块里去写，也可以另起一个方法（推荐）
			try {
				flag = !flag;  //扳开关
				this.getResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("出错了");
				e.printStackTrace();
			}
		}else if ("S".equals(btnStr)){
			//stop
			this.stopTime();
			showText.setText("");
			
		}else if ("T".equals(btnStr)){
			//start
			this.startTime();
			
		}else if ("<—".equals(btnStr)) {
			
			//System.out.println(2.00-1.10);
			//退格
			//获得现在在输入框里的字符
			String oldStr = showText.getText();
			//获得当前字符串的长度
			int len = oldStr.length();
			
			//判断  退格到最后一个的时候再按没有用
			if(len == 0) {
				//System.out.println("里面没有东西了");
				showText.setText("");
				return;
			}
			
			//根据当前字符串的长度选择性的截取   长度-1
			int reallen = len-1;
			//截取字符串  
			String newStr = oldStr.substring(0,reallen);
			//放到text上
			showText.setText(newStr);
			
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
			//把开关扳回来
			if(flag==false) {
				this.appendBtnText(showText, btnstr);
			}else {
				showText.setText("");
				this.appendBtnText(showText, btnstr);
				flag=!flag;
			}
		}
		
		
		
	}
}
