package com.budgetingapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.budgetingapp.domain.User;
import com.budgetingapp.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepo.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User does not Exist");
		return new SecurityUser(user);
	}
}
