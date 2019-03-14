package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserModelDao;
import com.app.model.User;
import com.app.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserModelDao dao;
	
	@Transactional
	public User saveUser(User user) {
		return dao.save(user);
	}

	@Transactional
	public User updateUser(User user) {
		return dao.save(user);
	}

	@Transactional
	public void deleteUser(int id) {
		User user=new User();
		user.setId(id);
		dao.delete(user);
	}

	@Transactional(readOnly=true)
	public Optional<User> getUserById(int id) {
		return dao.findById(id);
	}

	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		List<User> list=new ArrayList<>();
		dao.findAll().forEach(e->list.add(e));
		return list;
	}

	@Transactional(readOnly=true)
	public List<User> findByEmail(String email) {
		List<User> list=new ArrayList<>();
		dao.findAll().forEach(e->list.add(e));
		return list;
	}

	@Transactional(readOnly=true)
	public long count(String email) {
		return dao.count(email);
	}
	

}
