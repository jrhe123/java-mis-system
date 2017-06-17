package com.mhl.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index extends JWindow implements Runnable{

	paint p;
	
	public static void main(String[] args) {
		Index index = new Index();
		Thread t = new Thread(index);
		t.start();
	}
	
	public Index(){
		
		p = new paint();
		this.add(p);
		
		this.setSize(400, 250);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-125);
		this.setVisible(true);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(500 * 30);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("go to login page");
			new UserLogin();
			this.dispose();
			break;
		}
	}
}


/*
 * Opening
 */
class paint extends JPanel implements Runnable
{
	Thread t;
	int x=10;
	int i=0,j=40,u=10;
	String gg[]={"L","o","a","d","i","n","g"};
	int k=0,tt=0;
	String shi[]={"Roy","Java","Demo","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"};
	Font f=new Font("TimesRoman",Font.PLAIN,10);
	
	boolean ifok=true;
	int width=180;
	int height=0;
	int dian=0;
	
	paint()
	{
		t=new Thread(this);
		t.start();
	}
	
	public void run()
	{
		while(true)
		{
			if(x<=380)		repaint();
			try {
				Thread.sleep(70);
				i++;
				j=j-6;
				u=u+10;				
				if(tt==3)	width=width-20;
				if(i==4)
				{
					tt++;
					if(ifok&&x>120+k*20)	k++;
					if(k>=gg.length-1)	ifok=false;
					x=x+10;
					i=0;
					j=40;
					u=10;
					dian++;
					if(dian>3)	dian=0;
				}
			} catch (Exception e) {
				System.out.println("thread break");
				e.printStackTrace();
			}			
		}
	}
	
	public void paintComponent(Graphics g)
	{		
		Image image;
		image=Toolkit.getDefaultToolkit().getImage("image\\sp.jpg");
		g.drawImage(image, 0, 0, this.getWidth(), 200, this);
		
		int r=(int )(Math.random()+255);
		int b=(int )(Math.random()+255);
		int y=(int )(Math.random()+255);
	
		g.setColor(new Color(253,250,250));
		g.fillRect(x, 210, 390-x, 30);
		g.setColor(new Color(253,250,250));
		if(i>1)		g.fillRect(x, 225-(j+20)/2,10,j+20);
		if(j>25)	g.setColor(new Color(r,b,y));
		else g.setColor(new Color(123,194,252));
		g.fillRect(x, 225-j/2,10, j);
		g.setColor(new Color(123,194,252));
		g.drawRect(10, 210, 380, 30);
		
		if(x<120)
		{
			for(int l=0;l<gg.length;l++)
			{
				g.setColor(new Color(0,0,0));
				
				g.drawString(gg[l], 120+l*20, 230);
			}
			
			for(int l=0;l<dian;l++)
			{
				g.setColor(new Color(0,0,0));
				
				g.drawString("*", 300+l*10, 235);
			}
			g.drawString("*",300+10*dian,235);
		}
		else
		{
			g.setColor(new Color(255,255,255));
			g.drawString(gg[k], 120+k*20, 230);
			
			for(int l=k+1;l<gg.length;l++)
			{
				g.setColor(new Color(0,0,0));
				g.drawString(gg[l],120+l*20,230);
			}
			if(x>300+dian*10)	g.setColor(new Color(255,255,255));
			
			for(int l=0;l<dian;l++)
			{
				g.drawString("*", 300+l*10, 235);
			}
			g.drawString("*",300+10*dian,235);
		}
		if(tt<3)
		{
			for(int rr=0;rr<=tt;rr++)
			{
				g.setColor(new Color(r,b,y));
				g.drawString(shi[rr],180, 60+rr*20);
			}
			g.drawString(shi[tt],180,60+tt*20);
		}
		
		if(tt>=3&&tt<7)
		{
			g.setColor(new Color(255,255,255));
			for(int rr=0;rr<3;rr++)	g.drawString(shi[rr],180,60+rr*20);
			g.setColor(new Color(r,b,y));
			if(tt<8)	for(int rr=3;rr<=tt;rr++) g.drawString(shi[rr], 150, rr*20-20);			
			if(tt>=7){ for(int rr=3;rr<8;rr++) g.drawString(shi[rr], 150, rr*20-20);}
		}
		if(tt>=7&&tt<13)
		{
			g.setColor(new Color(255,255,255));
			for(int rr=0;rr<3;rr++)	g.drawString(shi[rr],180,60+rr*20);
			for(int rr=3;rr<=7;rr++)	g.drawString(shi[rr],150, rr*20-20);
			g.setColor(new Color(r,b,y));
			if(tt<13)	for(int rr=8;rr<=tt;rr++)	g.drawString(shi[rr], 120, rr*20-120);
			if(tt>13)	{for(int rr=9;rr<13;rr++)	g.drawString(shi[rr], 120, rr*20-120);}
			
		}
		if(tt>=13&&tt<18)
		{
			g.setColor(new Color(255,255,255));
			for(int rr=0;rr<3;rr++) g.drawString(shi[rr], 180, 60+rr*20);
			for(int rr=3;rr<=7;rr++)	g.drawString(shi[rr], 150,rr*20-20);
			for(int rr=0;rr<13;rr++)	g.drawString(shi[rr], 120, rr*20-120);
			g.setColor(new Color(r,b,y));
			if(tt<18)	for(int rr=13;rr<=tt;rr++)	g.drawString(shi[rr], 90, rr*20-220);
			if(tt>=18){	for(int rr=13;rr<13;rr++)	g.drawString(shi[rr], 90, rr*20-220);}
			
		}
		
		if(tt>=18&&tt<23)
		{
			g.setColor(new Color(255,255,255));
			for(int rr=0;rr<3;rr++)	g.drawString(shi[rr], 180, 60+rr*20);
			for(int rr=3;rr<=7;rr++)	g.drawString(shi[rr], 150, rr*20-20);
			for(int rr=8;rr<13;rr++)	g.drawString(shi[rr], 120, rr*20-120);
			for(int rr=13;rr<18;rr++)	g.drawString(shi[rr], 90, rr*20-220);
			g.setColor(new Color(r,b,y));
			if(tt<23)	for(int rr=18;rr<=tt;rr++)	g.drawString(shi[rr], 60, rr*20-320);
			if(tt>=23){for(int rr=18;rr<23;rr++)	g.drawString(shi[rr], 60, rr*20-320);}
			
		}
		if(tt>=23&&tt<30)
		{
			g.setColor(new Color(255,255,255));
			for(int rr=0;rr<3;rr++)	g.drawString(shi[rr], 180, 60+rr*20);
			for(int rr=3;rr<=7;rr++)	g.drawString(shi[rr], 150, rr*20-20);
			for(int rr=8;rr<13;rr++)	g.drawString(shi[rr], 120, rr*20-120);
			for(int rr=13;rr<18;rr++)	g.drawString(shi[rr], 90, rr*20-220);
			for(int rr=18;rr<23;rr++)	g.drawString(shi[rr], 60, rr*20-320);
			g.setColor(new Color(r,b,y));
			if(tt<30)	for(int rr=23;rr<=tt;rr++)	g.drawString(shi[rr], 30, rr*20-400);
			if(tt>=30){for(int rr=23;rr<30;rr++)	g.drawString(shi[rr], 30, rr*20-220);}
			
		}
		if(tt>30)
		{
			g.setColor(new Color(255,255,255));
			for(int rr=0;rr<3;rr++)	g.drawString(shi[rr], 180, 60+rr*20);
			for(int rr=3;rr<=7;rr++)	g.drawString(shi[rr], 150, rr*20-20);
			for(int rr=8;rr<13;rr++)	g.drawString(shi[rr], 120, rr*20-120);
			for(int rr=13;rr<18;rr++)	g.drawString(shi[rr], 90, rr*20-220);
			for(int rr=18;rr<23;rr++)	g.drawString(shi[rr], 60, rr*20-320);
			for(int rr=23;rr<30;rr++)	g.drawString(shi[rr], 30, rr*20-400);	
		}	
	}
}