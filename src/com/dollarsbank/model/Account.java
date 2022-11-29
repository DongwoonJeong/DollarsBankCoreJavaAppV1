package com.dollarsbank.model;

import java.util.List;


// Account
public class Account {

	
	private int acc_id;
	private String name;
	private String password;
	private String address;
	private String contact;
	private List<String> history;
	
	


	public Account(int acc_id, String name, String password, String address, String contact, List<String> history) {
		super();
		this.acc_id = acc_id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.contact = contact;
		this.history = history;
	}


	public int getAcc_id() {
		return acc_id;
	}


	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public List<String> getHistory() {
		return history;
	}


	public void setHistory(List<String> history) {
		this.history = history;
	}


	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", contact=" + contact + ", history=" + history + "]";
	}
	
	
	
}
