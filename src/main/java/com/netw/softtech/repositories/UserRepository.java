package com.netw.softtech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netw.softtech.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	//User findOne(String email);

	User findByEmailLike(String email);

	List<User> findByNameLike(String name);

}
