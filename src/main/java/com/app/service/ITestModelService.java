package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.TestModel;

public interface ITestModelService {
	public TestModel saveTestModel(TestModel test);
	public TestModel updateTestModel(TestModel test);
	public void deleteTestModel(Integer id);
	public Optional<TestModel> getTestModelById(Integer id);
	public List<TestModel> getAllTestModels();
	List<TestModel> findByUserEmail(String email);
}
