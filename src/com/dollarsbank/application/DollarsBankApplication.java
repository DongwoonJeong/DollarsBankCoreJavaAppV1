package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;
import java.util.*;

public class DollarsBankApplication {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		DollarsBankController control = new DollarsBankController();

		while (run) {
			System.out.println("+----------------+");
			System.out.println("|--Dollars Bank--|");
			System.out.println("+----------------+");
			System.out.println("1. Create New Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			int select = sc.nextInt();
			if (select == 1) {
				control.createAccount();
			}
			if (select == 2) {
				control.bankLogin();
			}
			if (select == 3) {
				System.out.println("system terminating");
				run = false;
			}
		}
		sc.close();

	}

}
