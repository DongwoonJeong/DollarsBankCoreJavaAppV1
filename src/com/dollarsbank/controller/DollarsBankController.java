package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.dao.BankDao;
import com.dollarsbank.exception.BadLoginCredentialException;
import com.dollarsbank.model.Account;

public class DollarsBankController {
	// BankDao banksql = new BankDao();
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	Scanner input = new Scanner(System.in);

	public void createAccount() {

		String username = "";
		String password = "";
		String address = "";
		String contact = "";
		int initial = 0;
		boolean create = false;

		System.out.println("+----------------------------+");
		System.out.println("|  DOLLARSBANK Welcomes You  |");
		System.out.println("+----------------------------+");

		while (create != true) {
			System.out.println("Customer Name:");
			username = input.nextLine();
			System.out.println("Customer Contact Email:");
			contact = input.nextLine();
			System.out.println("Customer Address:");
			address = input.nextLine();
			System.out.println("User Id: ");
			String acc_id = input.nextLine();
			System.out.println("Passwod : 8 Characters With Lower,Upper & Special");
			password = input.nextLine();
			System.out.println("Initial Deposit Amout");
			initial = input.nextInt();
			// banksql.CreateUser(username, contact, address, password, initial);
			accounts.add(new Account(acc_id, username, contact, address, password, initial, null));
			System.out.println("account created : " + accounts);
			create = true;

		}

	}

	public void bankLogin() {
		
		accounts.add(new Account("1","1","1","1","1",1,null));
		accounts.add(new Account("2","John","1123451","211 USA","12",1000,null));
		boolean login = false;
		System.out.println("+---------------------+");
		System.out.println("| Enter Login Details |");
		System.out.println("+---------------------+");
		System.out.println("User Id :");
		String acc_id = input.nextLine();
		System.out.println("Passwod :");
		String password = input.nextLine();
		while (!login) {
			try {
				for (Account acc : accounts) {
					if (acc.getAcc_id().equals(acc_id) && acc.getPassword().equals(password)) {
						System.out.println("login success");
						login = true;
					} else {
						System.out.println("id does not exist.");
						
					}
				}
			} catch (Exception e) {

			}
		}
			while (login) {
				try {
					System.out.println("+---------------------+");
					System.out.println("| Welcome customer!!! |");
					System.out.println("+---------------------+");
					System.out.println("1. Deposit Amount");
					System.out.println("2. Withdraw Amount");
					System.out.println("3. Funds Transfer");
					System.out.println("4. View 5 Recent Transactions");
					System.out.println("5. Display Customer Information");
					System.out.println("6. Sign Out");

					int selec = Integer.parseInt(input.nextLine());
					int id = Integer.parseInt(acc_id);
					switch (selec) {
					case 1:
						System.out.println("deposit amount");
						double depo = input.nextInt();

						deposit(acc_id, depo);
						break;
					case 2:
						withraw();
						break;
					case 3:
						transfer();
						break;
					case 4:
						history();
						break;
					case 5:
						info(id - 1);
						break;
					case 6:
						login = false;

					}
				} catch (InputMismatchException e) {
					System.out.println("\nPlease enter a vaild option\n");
				}
			}
		}
	



	private void info(int id) {
		System.out.println("--------------------------------");
		System.out.println("User Id: " + id+1);
		System.out.println("User Name: " + accounts.get(id).getName());
		System.out.println("Address: " + accounts.get(id).getAddress());
		System.out.println("Balance: " + accounts.get(id).getInitial());
		System.out.println("--------------------------------");
	}

	private void history() {

	}

	private void transfer() {

	}

	private void withraw() {

	}

	private void deposit(String id, double depo) {
		double bal=0;
		for (Account acc : accounts) {
			if(acc.getAcc_id().equals(id)) {
				bal = depo + acc.getInitial();
				System.out.println("Deposited " + bal);
			}
			
			} 
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
