package com.briup.test;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class CardLayoutTest extends JFrame{
	private Container contentPane;
	private JButton btn1,btn2,btn3,btn4,btn5;
	private JPanel centerPanel;
	private JButton[] btns=new JButton[4];
	private String[] msg = {"one","two","three","four"};
	private Color[] colors ={Color.red,Color.BLUE,Color.yellow,Color.GREEN};
	private CardLayout card;
	
	public CardLayoutTest(){
		super("��Ƭ����");
		Rectangle r = new Rectangle(200,250,400,400);
		setBounds(r);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		contentPane = getContentPane();
		initGUI();
	}
	public void initGUI(){
		//�ȴ�����Ƭ
		card = new CardLayout();
		centerPanel = new JPanel(card);
		for(int i=0;i<btns.length;i++){
			btns[i]=new JButton(msg[i]);
			//��ӿ�Ƭ���ֵ������Ҫ��ӱ�ʶ
			centerPanel.add(btns[i],msg[i]);
			btns[i].setBackground(colors[i]);
			btns[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					card.next(centerPanel);
				}
			});
		}
		contentPane.add(centerPanel);
		JPanel southPanel = new JPanel();
		btn1 = new JButton("first");
		btn2 = new JButton("next");
		btn3 = new JButton("pre");
		btn4 = new JButton("three");
		btn5 = new JButton("last");
		southPanel.add(btn1);
		southPanel.add(btn2);
		southPanel.add(btn3);
		southPanel.add(btn4);
		southPanel.add(btn5);
		contentPane.add(southPanel,BorderLayout.SOUTH);
		performed();
	}
	public void performed(){
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(centerPanel);
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(centerPanel);
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(centerPanel);
			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(centerPanel,"three");
			}
		});
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.last(centerPanel);
			}
		});
	}
	public void go(){
		setVisible(true);
	}
	public static void main(String[] args) {
		new CardLayoutTest().go();
	}
}
