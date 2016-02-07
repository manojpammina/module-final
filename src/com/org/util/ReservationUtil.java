package com.org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReservationUtil {

	private static final String DB_URL="jdbc:mysql://localhost:3306/rrs?zeroDateTimeBehavior=convertToNull";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="password";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("My SQL driver class loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading My SQL class");
			e.printStackTrace();
		}
	}
	public static Connection connect(){
			Connection con=null;
			
			try {
				con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				System.out.println("DB Connected");
			} catch (SQLException e) {
				System.out.println("Error getting connection");
				e.printStackTrace();
			}
			
			return con; 
		}
	
}
