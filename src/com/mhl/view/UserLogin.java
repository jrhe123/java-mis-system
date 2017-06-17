package com.mhl.view;

import com.mhl.model.UserModel;
import com.mhl.tools.MyTools;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class UserLogin extends JDialog implements ActionListener{

	JLabel jl1, jl2, jl3;
	JTextField jName;
	JPasswordField jPasswd;
	JButton jCon, jCancel;
	
	
	public static void main(String []args){
		
		UserLogin ul = new UserLogin();
	}
	
	public UserLogin(){
		
		Container ct = this.getContentPane();
		this.setLayout(null);
		
		// Logo
		thumbImage ti = new thumbImage();
		ti.setBounds(0, 0, 90, 120);
		ct.add(ti);
		
		// User Name
		jl1 = new JLabel("User Name");
		jl1.setBounds(60,190,150,15);
		jl1.setFont(MyTools.f1);
		jl1.setForeground(Color.white);
		ct.add(jl1);
		
		jName = new JTextField(20);
		jName.setFont(MyTools.f1);
		jName.setBounds(180, 190, 120, 30);
		jName.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jName);
		
		jl2 = new JLabel("(UserID)");
		jl2.setFont(MyTools.f2);
		jl2.setForeground(Color.white);
		jl2.setBounds(60, 210, 100, 15);
		ct.add(jl2);
		
		// Password
		jl3 = new JLabel("Password");
		jl3.setBounds(60,258,150,15);
		jl3.setFont(MyTools.f1);
		jl3.setForeground(Color.white);
		ct.add(jl3);
		
		jPasswd = new JPasswordField(20);
		jPasswd.setFont(MyTools.f1);
		jPasswd.setBounds(180, 250, 120, 30);
		jPasswd.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jPasswd);
		
		// btn
		jCon = new JButton("Login");
		jCon.addActionListener(this);
		jCon.setFont(MyTools.f1);
		jCon.setBounds(85, 300, 80, 30);
		jCon.setForeground(Color.white);
		jCon.setBackground(new Color(0,164,219));
		jCon.setOpaque(true);
		ct.add(jCon);
		
		jCancel = new JButton("Cancel");
		jCancel.addActionListener(this);
		jCancel.setFont(MyTools.f1);
		jCancel.setBounds(195, 300, 90, 30);
		jCancel.setForeground(Color.white);
		jCancel.setBackground(new Color(0,164,219));
		jCancel.setOpaque(true);
		ct.add(jCancel);
		
		BackImage bi = new BackImage();
		bi.setBounds(0, 0, 360, 360);
		ct.add(bi);
		this.setUndecorated(true);
		this.setSize(360, 360);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-125);
		this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == jCon){		
			System.out.println("go login here");
			
			String uid = this.jName.getText().trim();
			String passwd = new String(this.jPasswd.getPassword());

			UserModel um = new UserModel();
			String res = um.checkUser(uid, passwd);
			if(res.equals("Admin") || res.equals("Manager")){
				new Windows1();
				this.dispose();
			}
		}else if(arg0.getSource() == jCancel){
			this.dispose();
		}
	}
	
	
	
	class BackImage extends JPanel{
		Image im;
		public BackImage(){
			
			try {
				im = ImageIO.read(new File("image//login.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g){
			g.drawImage(im, 0, 0, 360, 360, this);
		}
	}
	
	class thumbImage extends JPanel {
		Image im;
		public thumbImage() {

			try {
				im = ImageIO.read(new File("image//java.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g) {
			g.drawImage(im, 0, 0, 90, 120, this);
		}
	}
}
