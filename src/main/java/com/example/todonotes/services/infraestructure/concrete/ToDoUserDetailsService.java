package com.example.todonotes.services.infraestructure.concrete;

import java.util.ArrayList;

import com.example.todonotes.repository.Entities.UserEntity;
import com.example.todonotes.repository.infraestructure.abstraction.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ToDoUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		// org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder is used as crypto encoder for passwords.
		//
		// Example of using BCryptPasswordEncoder to generated a crypto password:
		//
		//	 	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// 		String password = passwordEncoder.encode("demo");

		UserEntity userEntity = userRepository.getUser(userName);

		if (userEntity != null) {
			return new User(userEntity.getUserName(), userEntity.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}

	}

}
