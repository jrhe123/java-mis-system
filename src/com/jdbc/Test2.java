package com.jdbc;

/* 0. jdbc -> odbc
 * 0. use jre 1.6
 * 1. Connect to odbc:
 * 	> control panel -> odbc data source
 * 	> 64-bit -> system DSN -> add -> SQL server
 * 
 * 2. JDBC: always add '' for integer or string
 * 3. CMD: netstat -an => check listening
 */
import java.sql.*;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class Test2 {

	public static void main(String[] args) {
		
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct = DriverManager.getConnection("jdbc:odbc:mytest2","sa","123456");
			
			// Ex:1
			ps = ct.prepareStatement("select * from dept where deptno=? and loc=?");
			// set condition base on type
			ps.setInt(1, 10);
			ps.setString(2, "new york");
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			// Ex:2
//			ps = ct.prepareStatement("insert into dept values(?,?,?)");
//			ps.setInt(1, 50);
//			ps.setString(2, "newnew");
//			ps.setString(3, "hongkong");
//			int i = ps.executeUpdate();
//			
//			if(i == 1){
//				System.out.println("ok");
//			}else {
//				System.out.println("failed");
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			try {
				if(rs != null){
					rs.close();
				}
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
