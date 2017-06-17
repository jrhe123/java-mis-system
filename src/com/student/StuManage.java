package com.student;

import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class StuManage extends JFrame implements ActionListener{

	JPanel jp1, jp2;
	JLabel jl1;
	JButton jb1, jb2, jb3, jb4;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;
	StuModel sm;
	

	public static void main(String[] args) {
		StuManage stuManage = new StuManage();	
	}
	
	public StuManage(){
		
		jp1 = new JPanel();
		jtf = new JTextField(10);
		jb1 = new JButton("search");
		jb1.addActionListener(this);
		//jb1.setActionCommand("search");
		jl1 = new JLabel("please enter name");
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2 = new JPanel();
		jb2 = new JButton("add");
		jb2.addActionListener(this);
		jb3 = new JButton("edit");
		jb3.addActionListener(this);
		jb4 = new JButton("delete");
		jb4.addActionListener(this);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
				
		//jt = new JTable(rowData, columnNames);		
		sm = new StuModel();
		String[] params = {};
		sm.queryStu("select * from stu", params);
		jt = new JTable(sm);
		jsp = new JScrollPane(jt);
		
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == jb1){
			System.out.println("search here");
			
			String name = this.jtf.getText().trim();
			String sql = "select * from stu where stuName =?";
			String[] params = {name};
			sm = new StuModel();
			sm.queryStu(sql, params);
			jt.setModel(sm);
		}else if(arg0.getSource() == jb2){
			System.out.println("insert here");
			
			StuAddDialog sa = new StuAddDialog(this, "add student", true);
			sm = new StuModel();
			String []params = {};
			sm.queryStu("select * from stu", params);
			jt.setModel(sm);
		}else if(arg0.getSource() == jb3){
			System.out.println("edit here");
			
			int row = this.jt.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(this, "please select edit row");
				return;
			}
			
			StuUpdDialog sa = new StuUpdDialog(this, "edit student", true, sm, row);
			sm = new StuModel();
			String []params = {};
			sm.queryStu("select * from stu", params);
			jt.setModel(sm);
			
		}else if(arg0.getSource() == jb4){
			System.out.println("delete here");
			
			int row = this.jt.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(this, "please select delete row");
				return;
			}
			String stuId = (String)sm.getValueAt(row, 0);
						
			String sql = "delete from stu where stuId=?";
			String[] params = {stuId};
			StuModel temp = new StuModel();
			temp.updStu(sql, params);
			
			sm = new StuModel();
			String []params2 = {};
			sm.queryStu("select * from stu", params2);
			jt.setModel(sm);
		}		
	}
	

}
