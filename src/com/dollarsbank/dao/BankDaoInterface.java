package com.dollarsbank.dao;

public interface BankDaoInterface {
	
	//login
	public boolean login(String username, String password);
	//create account
	void CreateUser(String username, String password, String contact, String address, int initialdeposit);
	//deposit
	void Deposit();
	//withraw
	void Withraw();
	//fund transfer
	void Transfer();
	//view 5 recent transactions
	void History();
	// display customer info
	void GetUser();
	// sign out
	
	
}
