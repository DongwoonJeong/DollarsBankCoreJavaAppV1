package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dollarsbank.connection.ConnManagerWithProperties;
import com.dollarsbank.exception.BadLoginCredentialException;





public class BankDao implements BankDaoInterface{

	private Connection connection = ConnManagerWithProperties.getConnection();
	
	@Override
	public boolean login(String user_id, String password) {
		try {

			PreparedStatement pstmt1 = connection
					.prepareStatement("Select user_id from bank_user where user_id = ? ");
			PreparedStatement pstmt2 = connection
					.prepareStatement("Select user_password from bank_user where user_password = ?");
			pstmt1.setString(1, user_id);
			pstmt2.setString(1, password);
			// pstmt1.setString
			ResultSet rs1 = pstmt1.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
			boolean exists1 = rs1.next();
			boolean exists2 = rs2.next();

			if (exists1 == true && exists2 == true) {
				System.out.printf("\n\n\nWelcome %s\n", user_id);
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
	public void CreateUser(String username,  String contact, String address, String password, int initialdeposit) {
			try {
				PreparedStatement pstmt = connection
						.prepareStatement("Insert bank_user(user_id, user_name, user_contact, user_address, user_password, user_initialdeposit)" + "value(NULL,?,?,?, ?, ?)");
				pstmt.setString(1, username);
				pstmt.setString(2, contact);
				pstmt.setString(3, address);
				pstmt.setString(4, password);
				pstmt.setInt(5, initialdeposit);
				pstmt.executeUpdate();
				System.out.printf("\nThank you for join %s\n", username);

			} catch (Exception e) {
				System.out.println("Something went wrong, cannot create new account");
			}
		}

	@Override
	public void Deposit() {
		// TODO Auto-generated method stub
		try {

			PreparedStatement pstmt = connection
					.prepareStatement("update watch_instance set watch_instance.status_id = ? "
							+ "where watch_instance.show_id = ? && watch_instance.user_id = ?");
//			pstmt.setInt(1, x);
//			pstmt.setInt(2, getShowId(showTitle));
//			pstmt.setInt(3, getUserId(username));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Can not complete request. Soory:)");

		}

	}
		
	

	@Override
	public void Withraw() {
		try {

			PreparedStatement pstmt = connection
					.prepareStatement("update watch_instance set watch_instance.status_id = ? "
							+ "where watch_instance.show_id = ? && watch_instance.user_id = ?");
//			pstmt.setInt(1, x);
//			pstmt.setInt(2, getShowId(showTitle));
//			pstmt.setInt(3, getUserId(username));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Can not complete request. Soory:)");

		}

	}
		
	

	@Override
	public void Transfer() {
		try {

			PreparedStatement pstmt = connection
					.prepareStatement("update watch_instance set watch_instance.status_id = ? "
							+ "where watch_instance.show_id = ? && watch_instance.user_id = ?");
//			pstmt.setInt(1, x);
//			pstmt.setInt(2, getShowId(showTitle));
//			pstmt.setInt(3, getUserId(username));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Can not complete request. Soory:)");

		}

	}

	@Override
	public void History() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GetUser() {
		// TODO Auto-generated method stub
		
	}

	private int getUserId(String username) {

		try {
			PreparedStatement pstmt = connection.prepareStatement("Select user_id from bank_user where user_name = ?");
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("user_id");

				return id;
			}
		} catch (SQLException e) {
			System.out.println("User: = " + username + " not found.");
		}
		return -1;
	}
	
	private int getAccountId(String username) {

		try {
			PreparedStatement pstmt = connection.prepareStatement("Select user_id from TV_user where user_name = ?");
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("user_id");

				return id;
			}
		} catch (SQLException e) {
			System.out.println("User: = " + username + " not found.");
		}
		return -1;
	}
}
