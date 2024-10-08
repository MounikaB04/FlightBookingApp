package com.flightBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
	private static Connection con = null;
	
	public static void registration(Scanner sc) throws ClassNotFoundException, SQLException {
	 con =  DBConfiguration.getConnection();
	 System.out.println("Enter the username");
	 String userName = sc.next();
	 System.out.println("Enter th"
	 		+ "e password");
	 String password = sc.next();
	 
	 PreparedStatement stmt = con.prepareStatement("insert into user (username,password) values(?,?) ");
	 stmt.setString(1,userName);
	 stmt.setString(2, password);
	 int i = stmt.executeUpdate();
	 if(i>0) {
		 System.out.println("Registration successfull");
	 }
	 
	}
	
	public static LoginResponse Login(Scanner sc) throws ClassNotFoundException, SQLException {
		System.out.println("Enter the login credentials to proceed...");
		LoginResponse obj = new LoginResponse();
		Connection con = DBConfiguration.getConnection();
		System.out.println("Enter the username");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		
		String query = "select * from user where username = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getString(3).equals(password)) {
				obj.setUsername(userName);
				obj.setStatus(true);
			}
		}
		return obj;	
	}
}