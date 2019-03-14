package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.model.User;
public interface IUserModelDao extends CrudRepository<User,Integer> {
	/*@Query("select u.id from User u where u.email=?1")
	public Integer getId(String email);*/
	/*@Query("select u.id from User u where u.email=:email")
	public Integer getId(@Param("email") String email);*/
	List<User> findByEmail(String email);
	@Query("SELECT COUNT(u) FROM User u WHERE u.email=:email")
     long count(@Param("email")String email);
}
