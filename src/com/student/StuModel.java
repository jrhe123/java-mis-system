package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class StuModel extends AbstractTableModel{
	
	Vector rowData, columnNames;
	
	public StuModel(){
		
		
	}

	/*
	 * Search
	 */
	public void queryStu(String sql, String []params){

		SqlHelper sh = null;
		
		columnNames = new Vector();
		columnNames.add("stuNo");
		columnNames.add("name");
		columnNames.add("gender");
		columnNames.add("age");
		columnNames.add("country");
		columnNames.add("facility");
		rowData=new Vector();
		try {
			sh = new SqlHelper();
			ResultSet rs = sh.queryExecute(sql, params);
			
			while(rs.next()){
				Vector row = new Vector();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(String.valueOf(rs.getInt(4)));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				rowData.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sh.close();
		}
	}
		
	/*
	 * Add / Update/ Delete
	 */
	public boolean updStu(String sql, String []params){
		
		SqlHelper sh = new SqlHelper();
		return sh.updExecute(sql, params);
	}
	
	
	public int getColumnCount() {
		return this.columnNames.size();
	}

	public int getRowCount() {
		return this.rowData.size();
	}

	public Object getValueAt(int arg0, int arg1) {
		return ((Vector)this.rowData.get(arg0)).get(arg1);
	}	
	
	public String getColumnName(int arg0){
		return (String)this.columnNames.get(arg0);
	}
}
