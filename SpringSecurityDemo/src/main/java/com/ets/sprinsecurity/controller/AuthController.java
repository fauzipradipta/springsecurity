package com.ets.sprinsecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ets.sprinsecurity.payload.request.SignupRequest;
import com.ets.sprinsecurity.repo.RoleRepository;
import com.ets.sprinsecurity.repo.UserRepository;
import com.ets.sprinsecurity.response.MessageResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid SignupRequest signupRequest){
		
		//username should not be existing one
		if(userRepository.existsByUsername(signupRequest.getUsername())){
			return ResponseEntity.badRequest().body(new MessageResponse("error : username is already taken"));
		}
		
		if(userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("error: email is already taken"));
		}
	}
}
