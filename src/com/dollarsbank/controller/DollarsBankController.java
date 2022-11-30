package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dollarsbank.exception.AccountNotFoundException;
import com.dollarsbank.exception.BadLoginCredentialException;
import com.dollarsbank.model.Account;

public class DollarsBankController {
	// BankDao banksql = new BankDao();
	private ArrayList<Account> accounts = new ArrayList<Account>();

	Scanner input = new Scanner(System.in);

	public void createAccount() {
		Scanner sc2 = new Scanner(System.in);
		String username = "";
		String password = "";
		String address = "";
		String contact = "";
		int initial = 0;
		boolean create = false;

		System.out.println("+----------------------------+");
		System.out.println("|  DOLLARSBANK Welcomes You  |");
		System.out.println("+----------------------------+");

		while (!create) {
			System.out.println("Customer Name:");
			username = sc2.nextLine();
			System.out.println("Customer Contact Email:");
			contact = sc2.nextLine();
			System.out.println("Customer Address:");
			address = sc2.nextLine();
			System.out.println("User Id: ");
			String acc_id = sc2.nextLine();
			System.out.println("Passwod : 8 Characters With Lower,Upper & Special");
			password = sc2.nextLine();
			System.out.println("Initial Deposit Amout");
			initial = sc2.nextInt();
			// banksql.CreateUser(username, contact, address, password, initial);
			accounts.add(new Account(acc_id, username, contact, address, password, initial, null));
			System.out.println("account created : " + accounts);
			create = true;

		}

	}
	public boolean login(int id, String password) throws AccountNotFoundException{
		
		
		
		return false;
		
	}
	public void bankLogin() throws Exception {
		Scanner sc = new Scanner(System.in);

		accounts.add(new Account("0", "0", "0", "0", "0", 1, null));
		boolean login = false;
		System.out.println("+---------------------+");
		System.out.println("| Enter Login Details |");
		System.out.println("+---------------------+");
		System.out.println("User Id :");
		String acc_id = sc.nextLine();
		System.out.println("Passwod :");
		String password = sc.nextLine();

		while (!login) {

			try {
				//for (int i = 0; i < accounts.size(); i++) {
				//	if (accounts.get(i).getAcc_id() == acc_id) {
				//		System.out.println("123");
				for (Account acc : accounts) {
					if (acc.getAcc_id().equals(acc_id) && acc.getPassword().equals(password)) {
						System.out.println("login success");
						login = true;
					} else {
						System.out.println("user account cannot be found.");
						throw new BadLoginCredentialException();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
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

				int selec = input.nextInt();
				int id = Integer.parseInt(acc_id);
				switch (selec) {
				case 1:
					System.out.println("deposit amount");
					double depo = input.nextInt();

					deposit(acc_id, depo);
					break;
				case 2:
					System.out.println("withraw amount");
					double with = input.nextInt();
					withraw(acc_id, with);
					break;
				case 3:
					transfer();
					break;
				case 4:
					history();
					break;
				case 5:
					info(id);
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
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAcc_id().equals(String.valueOf(id))) {
		System.out.println("--------------------------------");
		System.out.println("User Id: " + accounts.get(i).getAcc_id());
		System.out.println("User Name: " + accounts.get(i).getName());
		System.out.println("Address: " + accounts.get(i).getAddress());
		System.out.println("Balance: " + accounts.get(i).getInitial());
		System.out.println("--------------------------------");
	}
		}
	}
	private void history() {

	}

	private void transfer() {

	}

	private void withraw(String id, double with) {

		for (Account acc : accounts) {
			if (acc.getAcc_id().equals(id)) {
				if (acc.getInitial() < with) {
					System.out.println("cant withdraw more that remaining balance.");

				} else {
					double bal = acc.getInitial() - with;
					System.out.println(with + " taken out. end balance : " + bal);
					acc.setInitial(bal);
				}
			}

		}
	}

	private void deposit(String id, double depo) {
		double bal = 0;
		if (depo > 0) {
			for (Account acc : accounts) {
				if (acc.getAcc_id().equals(id)) {
					bal = depo + acc.getInitial();
					System.out.println(depo + " Deposited. end balance : " + bal);
					acc.setInitial(bal);
				}

			}
		} else {
			System.out.println("deposit should be more then 0.");
		}
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
