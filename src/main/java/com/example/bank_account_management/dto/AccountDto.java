package com.example.bank_account_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private int account_Id;
	private int user_Id;
	private long account_no;
	private String account_Type;
	private double balance;
	private UserDto userDto;
}
