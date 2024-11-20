package com.example.bank_account_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank_account_management.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
