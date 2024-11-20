package com.example.bank_account_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bank_account_management.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.role_Name = :roleName")
	public Role findByRole_Name(String roleName);
}
