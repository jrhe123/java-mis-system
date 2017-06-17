package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {

	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";
	String user = "sa";
	String passwd = "123456";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public ResultSet queryExecute(String sql){
		try {
			// 1. Load the driver
			Class.forName(driver);
			// 2. Connect
			ct = DriverManager.getConnection(url, user, passwd);
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return rs;
	}
	
	public ResultSet queryExecute(String sql, String []params){
		try {
			// 1. Load the driver
			Class.forName(driver);
			// 2. Connect
			ct = DriverManager.getConnection(url, user, passwd);
			ps = ct.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				ps.setString(i+1, params[i]);
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return rs;
	}
	
	public boolean updExecute(String sql, String []params){
		boolean b = true;
		try {
			// 1. Load the driver
			Class.forName(driver);
			// 2. Connect
			ct = DriverManager.getConnection(url, user, passwd);
			ps = ct.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				ps.setString(i+1, params[i]);
			}
			if(ps.executeUpdate() != 1){
				b = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		} finally {
			this.close();
		}
		return b;
	}
	
	public void close(){
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (ct != null) {
				ct.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
