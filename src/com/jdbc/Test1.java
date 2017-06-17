package com.jdbc;

/* 0. jdbc -> odbc
 * 1. Connect to odbc:
 * 	> control panel -> odbc data source
 * 	> 64-bit -> system DSN -> add -> SQL server
 * 
 * 2. JDBC: always add '' for integer or string
 * 3. CMD: netstat -an => check listening
 * 4. sql server configuration manager -> SQL Server Network Configuration -> TCP/IP enable & Named Pipes enable
 */
import java.sql.*;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class Test1 {

	public static void main(String[] args) {
		
		Connection ct = null;
		Statement sm = null;
		try {
			
			// 1. Load the driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			// 2. Connect
			// 2.1 Window NT connect
			//ct = DriverManager.getConnection("jdbc:odbc:mytest2");
			// 2.2 User DSN connect
			ct = DriverManager.getConnection("jdbc:odbc:mytest2", "sa", "123456");
			
			// 3. Statement PreparedStatement
			sm = ct.createStatement();
			
			// 4. Execute SQL (curd, create DB, backup DB)
			// 4.1 executeUpdate: create / update / delete
//			int i = sm.executeUpdate("insert into dept values ('50','security','china')");
//			
//			if(i==1){
//				System.out.println("insert ok");
//			}else{
//				System.out.println("insert failed");
//			}
			
			// 4.2 
//			int i = sm.executeUpdate("delete from dept where deptno='50'");
//			if(i==1){
//				System.out.println("delete ok");
//			}else{
//				System.out.println("delete failed");
//			}
			
			// 4.3
//			int i = sm.executeUpdate("update dept set loc='beijing' where deptno='40'");
//			if(i==1){
//				System.out.println("update ok");
//			}else{
//				System.out.println("update failed");
//			}
			
			// 4.4 Select
			ResultSet rs = sm.executeQuery("select * from dept");
			
//			rs.next();
//			int a = rs.getInt(1);
//			String b = rs.getString(2);
			while(rs.next()){
				int deptno = rs.getInt(1);
				String dnameString = rs.getString(2);
				String locString = rs.getString(3);
				System.out.println(deptno+dnameString+locString);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			try {
				
				if(sm != null){
					sm.close();
				}
				if(ct != null){
					ct.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
