package com.dollarsbank.dao;

public interface BankDaoInterface {
	
	
	public boolean login(String username, String password); 
	void CreateUser(String username, String password, String contact, String address, int initialdeposit);
	
}
