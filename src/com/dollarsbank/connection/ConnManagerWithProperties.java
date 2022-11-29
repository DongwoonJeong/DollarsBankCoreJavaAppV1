package com.dollarsbank.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManagerWithProperties {
	
	// set connection to null right away
	private static Connection connection = null;
	
	private static void makeConnection() {
		
		// Properties will be used to access our properties file and read its values 
		Properties props = new Properties();
		
		// use the FileInputStream to load in the values from the file to props
		try {
			props.load(new FileInputStream("src/resources/config.properties"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// save the values to the variables, use the same name as what is written in the
		// file to get the values
		System.out.println("Connecting");
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		
		// finally, establish the connection
		try {
			connection = DriverManager.getConnection(url, username, password);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// will establish the connection if it it is not already made and return connection
	// object, making this a singleton design
	public static Connection getConnection() {
		
		if(connection == null) {
			makeConnection();
		}
		
		return connection;
	}
	
	// main only here to test our class is working correctly
	public static void main(String[] args) {
		
		Connection conn = ConnManagerWithProperties.getConnection();
		System.out.println("Made Connection");
		
		try {
			conn.close();
			System.out.println("Closed connection");
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
