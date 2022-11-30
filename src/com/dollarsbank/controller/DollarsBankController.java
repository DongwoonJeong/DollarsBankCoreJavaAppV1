package com.dollarsbank.controller;

import java.util.Scanner;

import com.dollarsbank.dao.BankDao;
import com.dollarsbank.exception.BadLoginCredentialException;



public class DollarsBankController {

		BankDao banksql = new BankDao();
	public void createAccount() {
		Scanner input = new Scanner(System.in);
		String username = "";
		String password = "";
		String address = "";
		String contact ="";
		int initial = 0;
		System.out.println("Customer Name:");
		username = input.nextLine();
		System.out.println("Customer Contact Email:");
		contact = input.nextLine();
		System.out.println("Customer Address:");
		address = input.nextLine();		
		System.out.println("Passwod : 8 Characters With Lower,Upper & Special");
		password = input.nextLine();
		System.out.println("Initial Deposit Amout");
		initial = input.nextInt();
		System.out.println(username+ contact+ address+ password+ initial);
		banksql.CreateUser(username, contact, address, password, initial);
		
	}

	public void bankLogin() {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		final int MAXATTEMPTS = 3;
		int logInAttenpts = 0;
		boolean entryStatus = false;
		String username = "";
		String password = "";
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
