package com.jdbc;

/* 0. jdbc
 * 1. import jdbc jar
 * 1.1 use jre 1.8
 * 2. Sql Server Configuration Manager -> SQL Server Network Configuration -> TCP/IP
 * 		-> IP Addresses -> remove dynamic port -> add 1433 to TCP Port
 */
import java.sql.*;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class Test3 {

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
			ps = ct.prepareStatement("select ename,sal,deptno from emp");
			// 4. Execute
			// 4.1 search : executeQuery()
			// 4.2 insert,delete,update : executeUpdate()
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				// 5.1 Use Column Name
				String name = rs.getString("ename");
				float sal = rs.getFloat("sal");
				String deptno = rs.getString("deptno");
				
				System.out.println("name: "+name);
				System.out.println("sal: "+sal);
				System.out.println("deptno: "+deptno);
				
				// 5.2 Use Column Index
				//System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getString(3));
			}			
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
