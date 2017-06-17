package com.mhl.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;
import java.sql.*;

public class SqlHelper {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection ct = null;
	String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";
	String user = "sa";
	String passwd = "123456";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public SqlHelper(){
		try {
			// 1. Load the driver
			Class.forName(driver);
			// 2. Connect
			ct = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	// Add, Update, Delete
	public boolean exeUpdate(String sql, String []params){
		boolean b = true;
		try {
			ps = ct.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				ps.setString(i+1, params[i]);
			}
			if(ps.executeUpdate() == -1){
				b = false;
			}
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}
	
	// Search
	public ResultSet query(String sql, String []params){
		try {
			ps = ct.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				ps.setString(i+1, params[i]);
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close(){
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(ct != null) ct.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
