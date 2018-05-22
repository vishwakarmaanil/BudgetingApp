package com.budgetingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetingapp.domain.User;

//template and class
public interface UserRepository extends JpaRepository<User, Long>
{
	// dynamically create select statement
	User findByUsername(String username);
}
