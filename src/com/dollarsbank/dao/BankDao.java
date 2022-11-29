package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dollarsbank.connection.ConnManagerWithProperties;
import com.dollarsbank.exception.BadLoginCredentialException;





public class BankDao implements BankDaoInterface{

	private Connection connection = ConnManagerWithProperties.getConnection();
	
	@Override
	public boolean login(String username, String inPassword) {
		try {

			PreparedStatement pstmt1 = connection
					.prepareStatement("Select user_name from bank_user where user_name = ? ");
			PreparedStatement pstmt2 = connection
					.prepareStatement("Select user_password from bank_user where user_password = ?");
			pstmt1.setString(1, username);
			pstmt2.setString(1, inPassword);
			// pstmt1.setString
			ResultSet rs1 = pstmt1.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
			boolean exists1 = rs1.next();
			boolean exists2 = rs2.next();

			if (exists1 == true && exists2 == true) {
				System.out.printf("\n\n\nWelcome %s\n", username);
				// add method that take care of after login.
				return true;
			} else if (exists1 == true) {
				throw new BadLoginCredentialException();
			} else if (exists2 == true) {

				throw new BadLoginCredentialException();
			}

		} catch (BadLoginCredentialException e) {
			e.getMessage();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void CreateUser(String username, String password) {

		
	}

}