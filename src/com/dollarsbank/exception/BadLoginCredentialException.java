package com.dollarsbank.exception;

public class BadLoginCredentialException extends Exception{

	private static final long serialVersionUID = 001;

	public BadLoginCredentialException()
	{
		super("Invalid Credentials. Try Again!");
	    
	}
}
