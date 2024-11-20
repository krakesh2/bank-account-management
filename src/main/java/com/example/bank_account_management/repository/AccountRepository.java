package com.example.bank_account_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bank_account_management.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.account_no = :account_no")
	Account findByAccount_no(long account_no);
}
