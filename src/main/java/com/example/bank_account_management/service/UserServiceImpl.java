package com.example.bank_account_management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_account_management.dto.AccountDto;
import com.example.bank_account_management.dto.DepositDto;
import com.example.bank_account_management.dto.LoginDto;
import com.example.bank_account_management.dto.UserDto;
import com.example.bank_account_management.entity.Account;
import com.example.bank_account_management.entity.Role;
import com.example.bank_account_management.entity.User;
import com.example.bank_account_management.repository.AccountRepository;
import com.example.bank_account_management.repository.RoleRepository;
import com.example.bank_account_management.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDto userRegister(UserDto userDto) {
		Role role = roleRepository.findByRole_Name(userDto.getRole_name());
		if (role != null) {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			user.setRole(role);
			User dbUser = userRepository.save(user);
			BeanUtils.copyProperties(dbUser, userDto);
			return userDto;
		}
		throw new IllegalArgumentException("Role not present...");
	}

	@Override
	public LoginDto login(LoginDto loginDto) {
		User user = userRepository.findByEmail(loginDto.getEmail());
		String password = loginDto.getPassword();
		String dbPassword = user.getPassword();
		if (user != null && password.equals(dbPassword)) {
			return loginDto;
		} else {
			throw new IllegalArgumentException("incorrect email or password...");
		}
	}

	@Override
	public AccountDto deposit(DepositDto depositDto) {
		Account account = accountRepository.findByAccount_no(depositDto.getAccount_no());
		if (account != null) {
			double balance = account.getBalance();
			if (depositDto.getAmount() == 0) {
				throw new IllegalArgumentException("Amount should be greater than or equal to 1...");
			}
			balance += depositDto.getAmount();
			account.setBalance(balance);
			Account dbAccount = accountRepository.save(account);
			AccountDto accountDto = new AccountDto();
			BeanUtils.copyProperties(dbAccount, accountDto);
			accountDto.setUser_Id(dbAccount.getUser().getId());
			User user = dbAccount.getUser();
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
			userDto.setRole_name(user.getRole().getRole_Name());
			accountDto.setUserDto(userDto);
			return accountDto;
		}
		throw new IllegalArgumentException("Account number does'nt exist...");

	}

	@Override
	public AccountDto withdraw(DepositDto depositDto) {
		Account account = accountRepository.findByAccount_no(depositDto.getAccount_no());
		if (account != null) {
			double balance = account.getBalance();
			if (depositDto.getAmount() == 0) {
				throw new IllegalArgumentException("Amount should be greater than or equal to 1...");
			}
			if (balance >= depositDto.getAmount()) {
				balance -= depositDto.getAmount();
				account.setBalance(balance);
				Account dbAccount = accountRepository.save(account);
				AccountDto accountDto = new AccountDto();
				BeanUtils.copyProperties(dbAccount, accountDto);
				accountDto.setUser_Id(dbAccount.getUser().getId());
				User user = dbAccount.getUser();
				UserDto userDto = new UserDto();
				BeanUtils.copyProperties(user, userDto);
				userDto.setRole_name(user.getRole().getRole_Name());
				accountDto.setUserDto(userDto);
				return accountDto;
			} else {
				throw new IllegalArgumentException("insufficient Balance....");
			}
		}
		throw new IllegalArgumentException("Account number does'nt exist...");

	}

}
