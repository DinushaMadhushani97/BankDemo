package com.fund;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FundDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    
	
	
	public static List<Fund> getFund(String Id) {
		int convertedID = Integer.parseInt(Id);
		ArrayList<Fund> pay = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from fund where id='"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String accNo = rs.getString(3);
				String branch = rs.getString(4);
				String amount = rs.getString(5);
				String message = rs.getString(6);
				
				
				Fund p = new Fund(id,name,accNo,branch,amount,message);
				pay.add(p);
			}
			
		} catch (Exception e) {
			
		}
		
		return pay;	
	}
    
    public static boolean insertfund(String name, String accNo, String branch, String amount, String message) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into fund values(0,'"+name+"','"+accNo+"','"+branch+"','"+amount+"','"+message+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
    
    public static boolean updatefund(String id, String name, String accNo, String branch, String amount, String message) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update fund set name='"+name+"',accNo='"+accNo+"',branch='"+branch+"',amount='"+amount+"',message='"
    				+ "where id='"+id+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
 
    public static List<Fund> getFundDetails(String Id) {
    	
    	int convertedID = Integer.parseInt(Id);
    	
    	ArrayList<Fund> pay = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from fund where id='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			
    			int id = rs.getInt(1);
				String name = rs.getString(2);
				String accNo = rs.getString(3);
				String branch = rs.getString(4);
				String amount = rs.getString(5);
				String message = rs.getString(6);
				
				
    			Fund p = new Fund(id,name,accNo,message,amount,message);
    			pay.add(p);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return pay;	
    }
    
    
    public static boolean deleteFund(String id) {
    	
    	int convId = Integer.parseInt(id);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from fund where id='"+convId+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }

	


    
}