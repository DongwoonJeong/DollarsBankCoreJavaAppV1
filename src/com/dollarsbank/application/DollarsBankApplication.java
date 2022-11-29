package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;
import java.util.*;
public class DollarsBankApplication {
	
	

	public static void main(String[] args) {
		boolean run = true;
		DollarsBankController control = new DollarsBankController();
		System.out.println("program starting");
		System.out.println("+----------------+");
		System.out.println("|--Dollars Bank--|");
		System.out.println("+----------------+");

		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. Create New Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			int selec = Integer.parseInt(scan.nextLine());
			switch(selec) {
			case 1:
				//create account
				control.createAccount();
				break;
			case 2:
				//login
				control.bankLogin();
				break;
			case 3:
				//exit
				
				run = false;
				System.out.println("terminating.");
				break;
			}
		}while(!run);
		
		
	}

}
