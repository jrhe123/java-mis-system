package com.mhl.view;

import com.mhl.tools.ImagePanel;
import com.mhl.tools.MyTools;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.*;

/*
 * Admin / Manager portal
 */
public class Windows1 extends JFrame implements ActionListener, MouseListener{
	
	Image titleIcon, timeBg;
	JMenuBar jmb;
	JMenu jm1, jm2, jm3, jm4, jm5, jm6;
	JMenuItem jmm1, jmm2, jmm3, jmm4, jmm5;
	ImageIcon jmm1_icon, jmm2_icon, jmm3_icon, jmm4_icon, jmm5_icon;
	Image img, newimg;
	JToolBar jtb;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;
	JPanel p1, p2, p3, p4, p5;
	JLabel timeNow;
	javax.swing.Timer t;
	
	ImagePanel p1_imgPanel;
	JLabel p1_lab1, p1_lab2, p1_lab3, p1_lab4, p1_lab5, p1_lab6, p1_lab7, p1_lab8;

	JLabel p2_lab1, p2_lab2;
	
	JSplitPane jsp;
	CardLayout cardP2, cardP3;
	
	

	public static void main(String[] args) {
		
		Windows1 w1 = new Windows1();
	}
	
	public Windows1(){
		
		// Thumb image
		try {
			titleIcon = ImageIO.read(new File("image/rLogo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Icon
		jmm1_icon = new ImageIcon("image/icon/icon3.png");
		img = jmm1_icon.getImage(); 
		newimg = img.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);  
		jmm1_icon = new ImageIcon(newimg); 
		
		jmm2_icon = new ImageIcon("image/icon/icon2.png");
		img = jmm2_icon.getImage(); 
		newimg = img.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);  
		jmm2_icon = new ImageIcon(newimg);
		
		jmm3_icon = new ImageIcon("image/icon/icon14.png");
		img = jmm3_icon.getImage(); 
		newimg = img.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);  
		jmm3_icon = new ImageIcon(newimg);
		
		jmm4_icon = new ImageIcon("image/icon/icon13.png");
		img = jmm4_icon.getImage(); 
		newimg = img.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);  
		jmm4_icon = new ImageIcon(newimg);
		
		jmm5_icon = new ImageIcon("image/icon/icon18.png");
		img = jmm5_icon.getImage(); 
		newimg = img.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);  
		jmm5_icon = new ImageIcon(newimg);
		
		// JMenu
		jm1 = new JMenu("System");
		jm1.setFont(MyTools.f1);
		// JMenuItem
		jmm1 = new JMenuItem("Switch user", jmm1_icon);
		jmm1.setFont(MyTools.f2);
		jmm2 = new JMenuItem("Money", jmm2_icon);
		jmm2.setFont(MyTools.f2);
		jmm3 = new JMenuItem("Login", jmm3_icon);
		jmm3.setFont(MyTools.f2);
		jmm4 = new JMenuItem("Calendar", jmm4_icon);
		jmm4.setFont(MyTools.f2);
		jmm5 = new JMenuItem("Exit", jmm5_icon);
		jmm5.setFont(MyTools.f2);
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		
		jm2 = new JMenu("User");
		jm2.setFont(MyTools.f1);
		jm3 = new JMenu("MenuList");
		jm3.setFont(MyTools.f1);
		jm4 = new JMenu("Data");
		jm4.setFont(MyTools.f1);
		jm5 = new JMenu("Money");
		jm5.setFont(MyTools.f1);
		jm6 = new JMenu("Help");
		jm6.setFont(MyTools.f1);
		
		jmb = new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		this.setJMenuBar(jmb);
		
		
		// Tool Bar
		jtb = new JToolBar();
		jtb.setFloatable(false);
		jb1 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon1.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb2 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon2.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb3 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon3.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb4 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon4.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb5 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon5.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb6 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon6.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb7 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon7.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb8 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon8.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb9 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon9.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jb10 = new JButton(new ImageIcon(new ImageIcon("image/icon/icon10.png").getImage().getScaledInstance(36, 36,  java.awt.Image.SCALE_SMOOTH)));
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
		
		
		// Panel
		// Center
		p1 = new JPanel(new BorderLayout());
		Image p1_bg = null;
		try {
			p1_bg = ImageIO.read(new File("image/sp.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		p1_imgPanel = new ImagePanel(p1_bg);
		
		Cursor myCursor = new Cursor(Cursor.HAND_CURSOR);
		
		p1_imgPanel.setLayout(new GridLayout(8,1));
		p1_lab1 = new JLabel(new ImageIcon("image/gif/demo1.gif"));
		p1_lab1.setFont(MyTools.f1);
		p1_imgPanel.add(p1_lab1);
		
		p1_lab2 = new JLabel("   Users     ", new ImageIcon(new ImageIcon("image/icon/icon11.png").getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH)) , 0);
		p1_lab2.setEnabled(false);
		p1_lab2.addMouseListener(this);
		p1_lab2.setCursor(myCursor);
		p1_lab2.setFont(MyTools.f1);
		p1_imgPanel.add(p1_lab2);
		
		p1_lab3 = new JLabel("   Login     ", new ImageIcon(new ImageIcon("image/icon/icon12.png").getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH)) , 0);
		p1_lab3.setEnabled(false);
		p1_lab3.addMouseListener(this);
		p1_lab3.setCursor(myCursor);
		p1_lab3.setFont(MyTools.f1);
		p1_imgPanel.add(p1_lab3);
		
		p1_lab4 = new JLabel("   Menu List ", new ImageIcon(new ImageIcon("image/icon/icon13.png").getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH)) , 0);
		p1_lab4.setEnabled(false);
		p1_lab4.addMouseListener(this);
		p1_lab4.setCursor(myCursor);
		p1_lab4.setFont(MyTools.f1);
		p1_imgPanel.add(p1_lab4);
		
		p1_lab5 = new JLabel("   Data      ", new ImageIcon(new ImageIcon("image/icon/icon14.png").getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH)) , 0);
		p1_lab5.setEnabled(false);
		p1_lab5.addMouseListener(this);
		p1_lab5.setCursor(myCursor);
		p1_lab5.setFont(MyTools.f1);
		p1_imgPanel.add(p1_lab5);
		
		p1_lab6 = new JLabel("   Analytics ", new ImageIcon(new ImageIcon("image/icon/icon15.png").getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH)) , 0);
		p1_lab6.setEnabled(false);
		p1_lab6.addMouseListener(this);
		p1_lab6.setCursor(myCursor);
		p1_lab6.setFont(MyTools.f1);
		p1_imgPanel.add(p1_lab6);
		
		p1_lab7 = new JLabel("   System    ", new ImageIcon(new ImageIcon("image/icon/icon16.png").getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH)) , 0);
		p1_lab7.setEnabled(false);
		p1_lab7.addMouseListener(this);
		p1_lab7.setCursor(myCursor);
		p1_lab7.setFont(MyTools.f1);
		p1_imgPanel.add(p1_lab7);
		
		p1_lab8 = new JLabel("   Help      ", new ImageIcon(new ImageIcon("image/icon/icon17.png").getImage().getScaledInstance(54, 54,  java.awt.Image.SCALE_SMOOTH)) , 0);
		p1_lab8.setEnabled(false);
		p1_lab8.addMouseListener(this);
		p1_lab8.setCursor(myCursor);
		p1_lab8.setFont(MyTools.f1);
		p1_imgPanel.add(p1_lab8);
		
		p1.add(p1_imgPanel);
		
		// p2 & p3 => (p4)
		p4 = new JPanel(new BorderLayout());
		
		cardP2 = new CardLayout();
		p2 = new JPanel(cardP2);
		p2_lab1 = new JLabel(new ImageIcon("image/left.png"));
		p2_lab1.addMouseListener(this);
		p2_lab2 = new JLabel(new ImageIcon("image/right.png"));
		p2_lab2.addMouseListener(this);
		
		p2.add(p2_lab1, "0");
		p2.add(p2_lab2, "1");
		
		cardP3 = new CardLayout();
		p3 = new JPanel(cardP3);
		
		Image main_image = null;
		try {
			main_image = ImageIO.read(new File("image/sp.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ImagePanel ip = new ImagePanel(main_image);
		p3.add(ip, "0");
		
		EmpInfo ei = new EmpInfo();
		p3.add(ei, "1");
		p3.add(new JLabel(new ImageIcon("image/icon/icon12.png")), "2");
		
		
		
		p4.add(p2, "West");
		p4.add(p3 ,"Center");
		
		jsp = new JSplitPane(jsp.HORIZONTAL_SPLIT, true, p1, p4);
		jsp.setDividerLocation(240);
		jsp.setDividerSize(0);
		
		
		// Bottom
		p5 = new JPanel(new BorderLayout());
		t = new Timer(1000, this);
		t.start();
		timeNow = new JLabel(Calendar.getInstance().getTime().toString()+ "     ");
		timeNow.setFont(MyTools.f2);
		timeNow.setForeground(Color.white);
		try {
			timeBg = ImageIO.read(new File("image/bottom-bar.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImagePanel ip1 = new ImagePanel(timeBg);
		ip1.setLayout(new BorderLayout());
		ip1.add(timeNow,"East");
		p5.add(ip1);
		
		
		// Setup
		Container ct = this.getContentPane();
		ct.add(jtb, "North");
		ct.add(jsp, "Center");
		ct.add(p5, "South");
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		this.setSize(w, h-30);
		this.setIconImage(titleIcon);
		this.setTitle("Java Demo Project");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		this.timeNow.setText(Calendar.getInstance().getTime().toString() + "     ");		
	}

	public void mouseClicked(MouseEvent arg0) {
		
		if(arg0.getSource() == this.p1_lab2){
			cardP3.show(p3, "1");
		}else if(arg0.getSource() == this.p1_lab3){
			cardP3.show(p3, "2");
		}
		
		if(arg0.getSource() == this.p2_lab1){
			cardP2.show(p2, "1");
			jsp.setDividerLocation(0);
		}else if(arg0.getSource() == this.p2_lab2){
			cardP2.show(p2, "0");
			jsp.setDividerLocation(240);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		
		if(arg0.getSource() == p1_lab2){
			p1_lab2.setEnabled(true);
		}else if(arg0.getSource() == p1_lab3){
			p1_lab3.setEnabled(true);
		}else if(arg0.getSource() == p1_lab4){
			p1_lab4.setEnabled(true);
		}else if(arg0.getSource() == p1_lab5){
			p1_lab5.setEnabled(true);
		}else if(arg0.getSource() == p1_lab6){
			p1_lab6.setEnabled(true);
		}else if(arg0.getSource() == p1_lab7){
			p1_lab7.setEnabled(true);
		}else if(arg0.getSource() == p1_lab8){
			p1_lab8.setEnabled(true);
		}
	}

	public void mouseExited(MouseEvent arg0) {
		
		if(arg0.getSource() == p1_lab2){
			p1_lab2.setEnabled(false);
		}else if(arg0.getSource() == p1_lab3){
			p1_lab3.setEnabled(false);
		}else if(arg0.getSource() == p1_lab4){
			p1_lab4.setEnabled(false);
		}else if(arg0.getSource() == p1_lab5){
			p1_lab5.setEnabled(false);
		}else if(arg0.getSource() == p1_lab6){
			p1_lab6.setEnabled(false);
		}else if(arg0.getSource() == p1_lab7){
			p1_lab7.setEnabled(false);
		}else if(arg0.getSource() == p1_lab8){
			p1_lab8.setEnabled(false);
		}
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
