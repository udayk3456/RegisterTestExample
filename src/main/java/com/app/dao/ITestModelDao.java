package com.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.model.TestModel;

public interface ITestModelDao extends CrudRepository<TestModel,Integer>{
	/*@Query("from TestModel t where t.userEmail=:userEmail")
	public List<TestModel> getData(@Param("userEmail") String userEmail);
	*/
	List<TestModel> findByUserEmail(String email);

}
