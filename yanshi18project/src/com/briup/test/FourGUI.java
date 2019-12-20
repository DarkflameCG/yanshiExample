package com.briup.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class FourGUI extends JFrame {
	
	//准备成员变量
	private JTextField text1;    //第一个文本框
	private JTextField text2;    //第二个文本框
	private JTextField textResult;    //结果文本框
	private JLabel addLabel;    //  +号
	private JLabel equalLabel;    //等于  =
	private JButton clickBtn;    //按钮，用来计算
	private JButton clearBtn;    //按钮，用来清空
	//准备一个桌布
	private Container container;
	
	//JFrame初始化的代码
	//构造器
	public FourGUI() {
		this.setTitle("计算器");
		this.setLocation(400,200);  
		this.setLayout(new FlowLayout());
		this.setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		container = this.getContentPane();
		container.setBackground(Color.CYAN);
		//方法的调用
		init();
		addChild();
		this.setVisible(true);
		
	}
	//方法重载
	public FourGUI(int height,int width) {
	}
	
	//控件初始化
	public void init() {
		//字体
		Font font = new Font("楷体", Font.BOLD, 20);
		
		text1 = new JTextField(9);		
		text1.setHorizontalAlignment(JTextField.RIGHT);
		text1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//System.out.println("Type");
				
	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println("Released");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("Pressed");
				//System.out.println(e.getKeyChar());//用来获得按了哪个字符
				//System.out.println(e.getKeyCode()); //获得每一个按键的编码
				//判断
				int code = e.getKeyChar();
				if(code>57||code<48)
				{	
					JOptionPane.showMessageDialog(container, "请正确输入");
					if(code == 10){
						//需要判断焦点的位置
						//当光标在第一个文本框的时候按下回车的时候
						//当光标在第二个文本框的时候按下回车的时候
					}else {				
						e.consume(); //阻止输入
					}
				}
				
			}
		});
		
		text2 = new JTextField(9);
		text2.setHorizontalAlignment(JTextField.RIGHT);
		
		textResult = new JTextField(9);
		textResult.setHorizontalAlignment(JTextField.RIGHT);
		textResult.setEnabled(false);
		
		addLabel = new JLabel("+");
		addLabel.setFont(font);
		
		equalLabel = new JLabel("=");
		equalLabel.setFont(font);
		
		clickBtn = new JButton("计算");
		clickBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("1："+text1.getText());
//				System.out.println("2："+text2.getText());
				
				//做一个简单的判断
				if("".equals(text1.getText()) || "".equals(text2.getText())) {
					System.out.println("请输入正确的数字");
					JOptionPane.showMessageDialog(container, "请输入正确的数字");
					//JOptionPane.showConfirmDialog(container, "是否要清空数字");
					//JOptionPane.showInputDialog("请输入你的名字");
					return;
				} 
				
				//1、正则表达式  /d代表数字
				String rexgep = "^//d//d$";
				
				//问题：如何打印  "joker"
//				String s = "\"joker\"";
//				System.out.println(s);
				
				//2、使用键盘监听
				
				//计算一下和
				//获得第一个输入框的值
				int t1=Integer.parseInt(text1.getText());
				//获得第二个输入框的值
				int t2=Integer.parseInt(text2.getText());
				//计算和
				int sum = t1+t2;
				//把和的值赋给第三个输入框
				textResult.setText(String.valueOf(sum));
				
			}
		});
		
		clearBtn = new JButton("清空");
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//三个按钮全部置空
				text1.setText("");
				text2.setText("");
				textResult.setText("");
				
				//System.out.println(1/0.0);
				//知识点
//				String s = "";
//				String s1 = null;
//				String s2 = " ";
			}
		});
	}	
	
	//加入到容器当中
	public void addChild() {
		container.add(text1);
		container.add(addLabel);
		container.add(text2);
		container.add(equalLabel);
		container.add(textResult);
		container.add(clickBtn);
		container.add(clearBtn);
	}
	
}
