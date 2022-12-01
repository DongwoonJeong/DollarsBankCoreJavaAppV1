package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.exception.AccountNotFoundException;
import com.dollarsbank.exception.BadLoginCredentialException;
import com.dollarsbank.model.Account;

public class DollarsBankController {
	// BankDao banksql = new BankDao();
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private List<String> history = new ArrayList<>();
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
			
			accounts.add(new Account(acc_id, username, contact, address, password, initial, "initial deposit : "+initial+" "+new Date()));
			System.out.println("account created " + new Date());
			create = true;

		}

	}
	public boolean login(String id, String password) throws AccountNotFoundException{
		
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getAcc_id().equals(id) && accounts.get(i).getPassword().equals(password)) {
				return true;
			}
		}return false;
		
	}
	public void bankLogin() throws Exception {
		Scanner sc = new Scanner(System.in);

		accounts.add(new Account("0", "0", "0", "0", "0", 1, " "));
		boolean login = false;
		System.out.println("+---------------------+");
		System.out.println("| Enter Login Details |");
		System.out.println("+---------------------+");
		System.out.println("User Id :");
		String acc_id = sc.nextLine();
		System.out.println("Passwod :");
		String password = sc.nextLine();

	

			try {
				
					if (login(acc_id, password)) {
						System.out.println("login success");
						login = true;
					} else {
						while (!login) {
						System.out.println("user account cannot be found.");
						throw new BadLoginCredentialException();
					}
					}
				
			} catch (Exception e) {
				e.printStackTrace();
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
					System.out.println("To which user?");
					int accountTo = input.nextInt();
					System.out.println("Amount");
					int amount = input.nextInt();
					transfer(acc_id, accountTo, amount);
					break;
				case 4:
					history(id);
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

	private void history(int id) {
		System.out.println("+---------------------+");
		System.out.println("| Transaction History |");
		System.out.println("+---------------------+");
			for (Account acc : accounts) {
				if (acc.getAcc_id().equals(String.valueOf(id))) {
					System.out.println(acc.getHistory() + "\n");
				}
			}
		}
	

	private void transfer(String id, int accountTo, int amount) {
		for (Account acc : accounts) {
			if (acc.getAcc_id().equals(String.valueOf(id))) {
				if (acc.getInitial() < amount) {
					System.out.println("cant withdraw more that remaining balance.");

				} else {
					double bal = acc.getInitial() - amount;
			}
		}
	}
	}
	private void withraw(String id, double with) {

		for (Account acc : accounts) {
			if (acc.getAcc_id().equals(id)) {
				if (acc.getInitial() < with) {
					System.out.println("cant withdraw more that remaining balance.");

				} else {
					double bal = acc.getInitial() - with;

					String str = with + " taken out. end balance : " + bal + " " + new Date();
					System.out.println(str);
					acc.setInitial(bal);
					acc.setHistory(str + "\n");

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
					String str = depo + " Deposited. end balance : " + bal+ " " + new Date();
					System.out.println(str);
					acc.setInitial(bal);
					acc.setHistory(str+"\n");				
				}
			}
		} else {
			System.out.println("deposit should be more then 0.");
		}
	}

}
