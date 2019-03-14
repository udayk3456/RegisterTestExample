package com.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.TestModel;
import com.app.service.ITestModelService;



@RestController
@RequestMapping("/{*}/uday")
@CrossOrigin(origins= {"https://webtestapplication.cfapps.io/"})
public class ControllerClass {
	private static final Logger logger = Logger.getLogger("ControllerClass");
	@Autowired
	private ITestModelService service;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody TestModel test) {
		logger.info("In save method");
		System.out.println("TestModel: "+test);
		ResponseEntity<?> message=null;
		try{
			TestModel t=service.saveTestModel(test);
			message=new ResponseEntity<>("{\"text\":\"User of id '"+t.getId()+"' saved successfully\" }",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			message=new ResponseEntity<>("{\"text\":\"User details not saved successfully\" }",HttpStatus.NO_CONTENT);
		}
		return message;
	}
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<TestModel> list=service.getAllTestModels();
		if(list==null || list.isEmpty()) {
			message=new ResponseEntity<>("{\"text\":\"No data found\"}",HttpStatus.NO_CONTENT) ;
		}
		else {
			message=new ResponseEntity<List<TestModel>>(list,HttpStatus.OK);
		}
		return message;
	}
	@GetMapping("/getAll/{email}")
	public ResponseEntity<?> getData(@PathVariable("email")String userEmail){
		ResponseEntity<?> message=null;
		logger.info("In getData method");
		List<TestModel> list=service.findByUserEmail(userEmail);
		if(list==null || list.isEmpty()) {
			message=new ResponseEntity<>("{\"text\":\"No data found\"}",HttpStatus.NO_CONTENT) ;
		}
		else {
			message=new ResponseEntity<List<TestModel>>(list,HttpStatus.OK);
		}
		return message;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Integer id){
		ResponseEntity<?> message=null;
		try {
			service.deleteTestModel(id);
			message=new ResponseEntity<>("{\"text\":\"User of id '"+id+"' deleted successfully\"}",HttpStatus.OK) ;
		}catch(Exception e) {
			message=new ResponseEntity<>("{\"text\":\"Not deleted\"} ",HttpStatus.NO_CONTENT);
		}
		return message;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable("id")Integer id){
		ResponseEntity<?> message=null;
		try {
			Optional<TestModel> t=service.getTestModelById(id);
			message=new ResponseEntity<Optional<TestModel>>(t,HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<>("{\"text\":\"No data found for id '"+id+"' \"}",HttpStatus.NO_CONTENT);
		}
		return message;
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody TestModel test) {
		ResponseEntity<?> message=null;
		try{
			TestModel t=service.updateTestModel(test);
			message=new ResponseEntity<>("{\"text\":\"User of id '"+t.getId()+"' updated successfully\" }",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			message=new ResponseEntity<>("{\"text\":\"User details not updated successfully\" }",HttpStatus.NO_CONTENT);
		}
		return message;
	}
}
