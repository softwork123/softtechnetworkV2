package com.netw.softtech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.netw.softtech.model.Role;
import com.netw.softtech.model.User;
import com.netw.softtech.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
		
	}
	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
		
	}
	
	public User findByEmailLike(String email) {
		return userRepository.findByEmailLike("%"+email+"%");
	}
	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		User u = userRepository.findByEmailLike("%"+email+"%");
		if(u!=null) {
			return true;
		}else {
			return false;
		}
	}

}
