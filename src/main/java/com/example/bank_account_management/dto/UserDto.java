package com.example.bank_account_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private int id;
	private String name;
	private String email;
	private long mobile_No;
	private String password;
	private String role_name;
}
