package com.example.bank_account_management.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
