package com.mhl.model;

import java.sql.ResultSet;

import com.mhl.db.SqlHelper;

public class UserModel {
	
	SqlHelper sh = null;
	
	/**
	 * 
	 * @param uid
	 * @param p
	 * @return
	 */
	public String checkUser(String uid, String passwd){
		
		String position = "";
		
		try {
			String sql = "select Users.Position from Logins,Users where Logins.UserID=Users.UserID and Logins.UserID=? and Logins.Password=?";
			String []params = {uid, passwd};
			sh = new SqlHelper();
			ResultSet rs = sh.query(sql, params);
			if(rs.next()){
				position = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sh.close();
		}
		return position;
	}
	
}
