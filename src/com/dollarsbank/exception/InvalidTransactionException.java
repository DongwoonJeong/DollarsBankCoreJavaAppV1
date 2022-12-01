package com.dollarsbank.exception;

public class InvalidTransactionException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InvalidTransactionException() {
		super("Invalid Transaction. try it again.");
	}

}
