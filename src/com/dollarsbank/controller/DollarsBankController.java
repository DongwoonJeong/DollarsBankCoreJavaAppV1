package com.dollarsbank.controller;

import java.util.Scanner;

import com.dollarsbank.dao.BankDao;
import com.dollarsbank.exception.BadLoginCredentialException;



public class DollarsBankController {

	public void createAccount() {
		// TODO Auto-generated method stub
		
	}

	public void bankLogin() {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		final int MAXATTEMPTS = 3;
		int logInAttenpts = 0;
		boolean active = false;
		boolean entryStatus = false;
		String username = "";
		String password = "";
		BankDao banksql = new BankDao();
		while (logInAttenpts < MAXATTEMPTS && entryStatus == false && username.equalsIgnoreCase("")) {
			try {
				System.out.println("User Id :");
				username = input.nextLine();
				System.out.println("Password :");
				password = input1.nextLine();
			} catch (Exception e) {
				System.out.println("__Please enter a username__\n");
			}

			try {
				if (banksql.login(username, password) == true) {
					entryStatus = true;
				} else {
					username = "";
					password = "";
					logInAttenpts += 1;
					throw new BadLoginCredentialException();
				}
			} catch (BadLoginCredentialException e) {
				System.out.println("\n" + e.getMessage() + "\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
