package com.ets.sprinsecurity.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
	//1. secret key: which is used to create token 
	@Value("SpringSecurityDemo.app.jwtSecret")
	private String jwtSecret; 
	//2. expiry duration: which we will use it to invalidate the token.
	@Value("SpringSecurityDemo.app.jwtExpirationMs")
	private int jwtExpirationMS;
	
	
	public String generateJwtToken(Authentication authentication) {
		//the user credentials ===> authentication object(predefined) ==>
		//get UserDerailsImpl(defined by coder) ==> will hold the credentials
		
		
		
	}
}
