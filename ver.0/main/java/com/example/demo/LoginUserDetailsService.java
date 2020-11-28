package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginMapper loginMapper; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		//LoginForm input =new LoginForm();
		//input.setUsername(username);
		LoginForm outPut = loginMapper.selectById(username);
		if(outPut == null) {
            throw new UsernameNotFoundException(username + " is not found");
        }
		//PasswordEncoder passEnc = new BCryptPasswordEncoder();
		//outPut.setPassword(passEnc.encode(outPut.getPassword()));
		return new User(outPut);
	}

}
