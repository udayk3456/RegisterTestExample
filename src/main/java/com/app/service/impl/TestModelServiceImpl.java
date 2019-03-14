package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITestModelDao;
import com.app.model.TestModel;
import com.app.service.ITestModelService;
@Service
public class TestModelServiceImpl implements ITestModelService {
	private static final Logger logger = Logger.getLogger("TestModelServiceImpl");
	
	@Autowired
	private ITestModelDao dao;

	@Transactional
	public TestModel saveTestModel(TestModel test) {
		return dao.save(test);
	}

	@Transactional
	public TestModel updateTestModel(TestModel test) {
		return dao.save(test);
	}

	@Transactional
	public void deleteTestModel(Integer id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly=true)
	public Optional<TestModel> getTestModelById(Integer id) {
		return dao.findById(id);
	}

	@Transactional(readOnly=true)
	public List<TestModel> getAllTestModels() {
		List<TestModel> list=new ArrayList<>();
		dao.findAll().forEach(e->list.add(e));
		return list;
	}

	

	@Transactional(readOnly=true)
	public List<TestModel> findByUserEmail(String email) {
		List<TestModel> list=new ArrayList<>();
		logger.info("In findByEmail serviceImpl method");
		dao.findByUserEmail(email).forEach(e->list.add(e));
		return list;
	}

}
