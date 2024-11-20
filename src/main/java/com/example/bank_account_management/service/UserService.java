package com.example.bank_account_management.service;

import com.example.bank_account_management.dto.AccountDto;
import com.example.bank_account_management.dto.DepositDto;
import com.example.bank_account_management.dto.LoginDto;
import com.example.bank_account_management.dto.UserDto;

public interface UserService {

	public UserDto userRegister(UserDto userDto);

	public LoginDto login(LoginDto loginDto);

	public AccountDto deposit(DepositDto depositDto);

	public AccountDto withdraw(DepositDto depositDto);
}
