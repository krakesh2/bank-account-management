package com.example.bank_account_management.service;

import java.util.List;

import com.example.bank_account_management.dto.AccountDto;
import com.example.bank_account_management.dto.UserDto;
import com.example.bank_account_management.entity.Role;

public interface AdminService {

	public Role addRole(Role role);

	public AccountDto addAccount(AccountDto accountDto);

	public List<UserDto> getUsers();
}
