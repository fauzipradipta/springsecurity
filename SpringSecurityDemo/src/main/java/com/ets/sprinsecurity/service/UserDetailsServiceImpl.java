package com.ets.sprinsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ets.sprinsecurity.dto.User;
import com.ets.sprinsecurity.repo.UserRepository;
import com.ets.sprinsecurity.security.service.UserDetailsImpl;


public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByUsername(username).
				orElseThrow(()->new UsernameNotFoundException("User Not Found with username" + username ));
		return UserDetailsImpl.build(user);
	}

}
