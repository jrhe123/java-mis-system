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

public class StuUpdDialog extends JDialog implements ActionListener {

	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JButton jb1, jb2;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6;
	JPanel jp1, jp2, jp3;
	
	public StuUpdDialog(Frame owner, String title, boolean modal, StuModel sm, int rowNums){
		super(owner, title, modal);
		jl1 = new JLabel("stuNo");
		jl2 = new JLabel("name");
		jl3 = new JLabel("gender");
		jl4 = new JLabel("age");
		jl5 = new JLabel("jg");
		jl6 = new JLabel("faculty");
		
		jtf1 = new JTextField();
		jtf1.setText((String)sm.getValueAt(rowNums, 0));
		jtf1.setEditable(false);
		jtf2 = new JTextField();
		jtf2.setText((String)sm.getValueAt(rowNums, 1));
		jtf3 = new JTextField();
		jtf3.setText((String)sm.getValueAt(rowNums, 2));
		jtf4 = new JTextField();
		jtf4.setText((String)sm.getValueAt(rowNums, 3));
		jtf5 = new JTextField();
		jtf5.setText((String)sm.getValueAt(rowNums, 4));
		jtf6 = new JTextField();
		jtf6.setText((String)sm.getValueAt(rowNums, 5));
		
		jb1 = new JButton("edit");
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
			
			String sql = "update stu set stuName=? , stuSex=?, stuAge=?, stuJg=?, stuDept=? " +
					"where stuId=?";
			String[] params = {jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};
			
			StuModel temp = new StuModel();
			if(!temp.updStu(sql, params)){
				JOptionPane.showMessageDialog(this, "edit student failed");
			}
			this.dispose();
		}
		
	}
}
