package com.example.bank_account_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_account_management.dto.AccountDto;
import com.example.bank_account_management.dto.UserDto;
import com.example.bank_account_management.entity.Account;
import com.example.bank_account_management.entity.Role;
import com.example.bank_account_management.entity.User;
import com.example.bank_account_management.exception.UserNotFoundException;
import com.example.bank_account_management.repository.AccountRepository;
import com.example.bank_account_management.repository.RoleRepository;
import com.example.bank_account_management.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public AccountDto addAccount(AccountDto accountDto) {
		Optional<User> optionalUser = userRepository.findById(accountDto.getUser_Id());
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			Account account = new Account();
			BeanUtils.copyProperties(accountDto, account);
			account.setUser(user);
			Account dbAccount = accountRepository.save(account);
			BeanUtils.copyProperties(dbAccount, accountDto);
			return accountDto;
		}
		throw new UserNotFoundException("user not present....");
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> userList = userRepository.findAll();
		List<UserDto> userDtoList = new ArrayList<>();

		for (User user : userList) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
			userDtoList.add(userDto);
		}
            return userDtoList;
	}

}
