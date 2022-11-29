package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;

public class DollarsBankApplication {
	
	DollarsBankController control = new DollarsBankController();

	public static void main(String[] args) {
		
		
		System.out.println("program starting");
		boolean run = true;
		while (run) {
			switch () {
			case 1: {
				break;
			}
			case 2:
				break;
			case 3:
				run = false;
				break;
			default:
				break;
			}
		}
	}

}
