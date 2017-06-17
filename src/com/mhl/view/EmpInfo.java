package com.mhl.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import com.mhl.model.EmpModel;
import com.mhl.tools.MyTools;

public class EmpInfo extends JPanel implements ActionListener{
	
	JPanel p1, p2, p3, p4, p5;
	JLabel p1_lab;
	JTextField p1_jtf;
	JButton p1_jb;
	
	JLabel p3_lab;
	JButton p4_jb1, p4_jb2, p4_jb3, p4_jb4;
	
	JTable jTable;
	JScrollPane jsp;
	
	EmpModel em;
	
	public EmpInfo(){
		
		// Top
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab = new JLabel("Please enter user name");
		p1_lab.setFont(MyTools.f1);
		p1_jtf = new JTextField(20);
		p1_jb = new JButton("search");
		p1_jb.setFont(MyTools.f1);
		p1_jb.setForeground(Color.white);
		p1_jb.setBackground(new Color(0,164,219));
		p1_jb.setOpaque(true);
		
		p1.add(p1_lab);
		p1.add(p1_jtf);
		p1.add(p1_jb);
		
		// Center
		em = new EmpModel();
		String sql = "select UserID,Name,Gender,Position,Address from Users";
		String []params = {};
		em.query(sql, params);
		jTable = new JTable(em);
		p2 = new JPanel(new BorderLayout());
		jsp = new JScrollPane(jTable);
		p2.add(jsp);
				
		
		// Bottom
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3_lab = new JLabel("Total record *");
		p3_lab.setFont(MyTools.f1);
		p3.add(p3_lab);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("Detail");
		p4_jb1.setFont(MyTools.f1);
		p4_jb1.setForeground(Color.white);
		p4_jb1.setBackground(new Color(0,164,219));
		p4_jb1.setOpaque(true);
		
		p4_jb2 = new JButton("Add");
		p4_jb2.setFont(MyTools.f1);
		p4_jb2.setForeground(Color.white);
		p4_jb2.setBackground(new Color(0,164,219));
		p4_jb2.setOpaque(true);
		
		p4_jb3 = new JButton("Edit");
		p4_jb3.setFont(MyTools.f1);
		p4_jb3.setForeground(Color.white);
		p4_jb3.setBackground(new Color(0,164,219));
		p4_jb3.setOpaque(true);
		
		p4_jb4 = new JButton("Delete");
		p4_jb4.addActionListener(this);
		p4_jb4.setFont(MyTools.f1);
		p4_jb4.setForeground(Color.white);
		p4_jb4.setBackground(new Color(0,164,219));
		p4_jb4.setOpaque(true);
		
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
		
		p5 = new JPanel(new BorderLayout());
		p5.add(p3, "West");
		p5.add(p4, "East");
		
		this.setLayout(new BorderLayout());
		this.add(p1, "North");
		this.add(p2, "Center");
		this.add(p5, "South");
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == p4_jb4){
			System.out.println("delete emp");
			
			int selRow = jTable.getSelectedRow();
			String userID = (String)em.getValueAt(selRow, 0);
			if(!em.delEmpById(userID)){
				JOptionPane.showMessageDialog(null, "Delete employee failed");
			}else{
				JOptionPane.showMessageDialog(null, "Delete employee succeed");
			}
			
			String []params = {};
			em = new EmpModel();
			em.query("select UserID,Name,Gender,Position,Address from Users", params);
			jTable.setModel(em);
		}
	}
}
