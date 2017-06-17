package com.jdbc;

/* 0. jdbc
 * 1. import jdbc jar
 * 1.1 use jre 1.8
 * 2. Sql Server Configuration Manager -> SQL Server Network Configuration -> TCP/IP
 * 		-> IP Addresses -> remove dynamic port -> add 1433 to TCP Port
 */
import java.sql.*;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class Test4 {

	public static void main(String[] args) {
		
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			// 1. Load the driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2. Connect
			ct = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test","sa","123456");
			// 3. PreparedStatement
			//ps = ct.prepareStatement("create database ccc");
			//ps = ct.prepareStatement("create table xyz(id int)");
			ps = ct.prepareStatement("backup database vvv to disk='d:/123.bak'");	
			
			boolean b = ps.execute();
			if(!b){
				System.out.println("ok");
			}else{
				System.out.println("failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			try {
				
				if(ps != null){
					ps.close();
				}
				if(ct != null){
					ct.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
	}
}
