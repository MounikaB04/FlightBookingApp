package com.flightBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfiguration {
	private static final String url = "jdbc:mysql://localhost:3306/flight_booking";
	private static final String username = "root";
	private static final String password = "Root";
	
	private static Connection con = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(con==null) {
			con = DriverManager.getConnection(url,username,password);
		}
		return con;
	}

}