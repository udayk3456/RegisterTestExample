package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.app.model.User;

public interface IUserService {
	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(int id);
	public Optional<User> getUserById(int id);
	public List<User> getAllUsers();
	List<User> findByEmail(String email);
	long count(@Param("email")String email);
}
