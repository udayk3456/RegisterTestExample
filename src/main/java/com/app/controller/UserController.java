package com.app.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/{*}/uday")
@CrossOrigin(origins= {"https://webtestapplication.cfapps.io/"})
public class UserController {
	private static final Logger logger = Logger.getLogger("ControllerClass");
	@Autowired
	private IUserService userService;

	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		ResponseEntity<?> message=null;
		try{
			if(userService.count(user.getEmail())>0) {
				message=new ResponseEntity<String>("{\"text\":\""+user.getEmail()+ " already exists\" }",HttpStatus.OK);
			}else {
				userService.saveUser(user);
				message=new ResponseEntity<String>("{\"text\":\""+user.getEmail()+ "\" }",HttpStatus.OK);
		}
		}catch(Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			message=new ResponseEntity<String>("{\"text\":\"User details not logged successfully\" }",HttpStatus.NO_CONTENT);
		}
		return message;
	}
}
