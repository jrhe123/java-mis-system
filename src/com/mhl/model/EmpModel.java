package com.mhl.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.mhl.db.SqlHelper;

public class EmpModel extends AbstractTableModel{

	Vector<String> columns;
	Vector<Vector> rows;
	
	public boolean delEmpById(String empId){
		
		boolean b = true;
		String sql = "delete from Users where UserID=?";
		String []params = {empId};
		
		SqlHelper sh = new SqlHelper();
		
		try {
			b = sh.exeUpdate(sql, params);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		} finally{
			sh.close();
		}
		
		return b;
	}

	public void query(String sql, String []params){
		
		columns = new Vector<String>();
		rows = new Vector<Vector>();
		
		SqlHelper sh = new SqlHelper();
		ResultSet rs = sh.query(sql, params);		
		
		try {
			// Column
			ResultSetMetaData rsmt = rs.getMetaData();
			for(int i = 0; i < rsmt.getColumnCount(); i++){
				this.columns.add(rsmt.getColumnName(i+1));
			}
						
			while(rs.next()){
				
				// Rows
				Vector<String> temp = new Vector<String>();
				for(int i = 0; i < rsmt.getColumnCount(); i++){
					temp.add(rs.getString(i+1));
				}				
				rows.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sh.close();
		}
	}
	
	public int getColumnCount() {
		return columns.size();
	}

	public int getRowCount() {
		return rows.size();
	}

	public Object getValueAt(int arg0, int arg1) {
		return ((Vector)rows.get(arg0)).get(arg1);
	}
	
	public String getColumnName(int arg0){
		return columns.get(arg0).toString();
	}
}
