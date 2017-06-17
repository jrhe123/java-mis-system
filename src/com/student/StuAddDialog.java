package com.student;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StuAddDialog extends JDialog implements ActionListener {

	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JButton jb1, jb2;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6;
	JPanel jp1, jp2, jp3;
	
	public StuAddDialog(Frame owner, String title, boolean modal){
		super(owner, title, modal);
		jl1 = new JLabel("stuNo");
		jl2 = new JLabel("name");
		jl3 = new JLabel("gender");
		jl4 = new JLabel("age");
		jl5 = new JLabel("jg");
		jl6 = new JLabel("faculty");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		
		jb1 = new JButton("add");
		jb2 = new JButton("cancel");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);		
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1, BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		
		this.setSize(300,250);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == jb1){
			StuModel sm = new StuModel();
			String sql = "insert into stu values(?,?,?,?,?,?)";
			String[] params = {(String)jtf1.getText(),(String)jtf2.getText(),(String)jtf3.getText(),(String)jtf4.getText(),(String)jtf5.getText(),(String)jtf6.getText()};
			if(!sm.updStu(sql, params)){
				JOptionPane.showMessageDialog(this, "add student failed");
			}
			this.dispose();
		}
	}
	
	
}
