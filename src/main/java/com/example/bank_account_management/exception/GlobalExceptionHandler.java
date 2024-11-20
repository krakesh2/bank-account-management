package com.example.bank_account_management.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.bank_account_management.entity.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiResponse> roleNotFound(IllegalArgumentException e) {
		return ResponseEntity.badRequest().body(new ApiResponse(true, e.getMessage(), null));
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> userNotFound(UserNotFoundException e) {
		return ResponseEntity.badRequest().body(new ApiResponse(true, e.getMessage(), null));
	}
}
