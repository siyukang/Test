package com.free.sims.service;

import java.util.List;

import com.free.sims.domain.User;

/**
 * @author liuzeke
 * @version 1.0
 */
public interface UserService {

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(Long id);

	User getUserById(Long id);

	List<User> getUser();
	
	Long getId();
}
