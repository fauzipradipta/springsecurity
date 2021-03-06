package  com.ets.sprinsecurity.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ets.sprinsecurity.dto.User;
import com.ets.sprinsecurity.repo.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found with username" + username));
		return UserDetailsImpl.build(user);
	}
}
