package com.example.bank_account_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank_account_management.dto.DepositDto;
import com.example.bank_account_management.dto.LoginDto;
import com.example.bank_account_management.dto.UserDto;
import com.example.bank_account_management.entity.ApiResponse;
import com.example.bank_account_management.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<ApiResponse> login(@RequestBody LoginDto loginDto) {
		return ResponseEntity.ok(new ApiResponse(false, "Login successfully", userService.login(loginDto)));
	}

	@PostMapping("/register")
	public ResponseEntity<ApiResponse> userRegister(@RequestBody UserDto userDto) {
		return ResponseEntity
				.ok(new ApiResponse(false, "Registration Successfull....", userService.userRegister(userDto)));
	}
	
	@PostMapping("/deposit")
	public ResponseEntity<ApiResponse> deposit(@RequestBody DepositDto depositDto){
		return ResponseEntity.ok(new ApiResponse(false, "Deposit amount successfully....", userService.deposit(depositDto)));
	}
	
	@PutMapping("/withdraw")
	public ResponseEntity<ApiResponse> withdrwa(@RequestBody DepositDto depositDto){
		return ResponseEntity.ok(new ApiResponse(false, "withdrwa amount successfully....", userService.withdraw(depositDto)));
	}
}
