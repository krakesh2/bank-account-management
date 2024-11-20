package com.example.bank_account_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank_account_management.dto.AccountDto;
import com.example.bank_account_management.entity.ApiResponse;
import com.example.bank_account_management.entity.Role;
import com.example.bank_account_management.service.AdminService;

@RestController
@CrossOrigin("http://127.0.0.1:5500/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PostMapping("/addrole")
	public ResponseEntity<ApiResponse> addRole(@RequestBody Role role ){
		return ResponseEntity.ok(new ApiResponse(false, "Role Added Successfully.....", adminService.addRole(role)));
	}
	
	@PostMapping("/addaccount")
	public ResponseEntity<ApiResponse> addAccount(@RequestBody AccountDto accountDto){
		return ResponseEntity.ok(new ApiResponse(false, "Role Added Successfully.....", adminService.addAccount(accountDto)));
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<ApiResponse> getUsers() {
		return ResponseEntity.ok(new ApiResponse(false, "Data fetched Successfully.....", adminService.getUsers()));
	}
	
	
}
