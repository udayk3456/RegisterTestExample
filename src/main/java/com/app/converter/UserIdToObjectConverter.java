package com.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.model.User;
import com.app.service.IUserService;

@Component
public class UserIdToObjectConverter implements Converter<Object,User>{
	@Autowired
	private IUserService service; 
	
	@Override
	public User convert(Object id) {
		try {
		int uid=Integer.parseInt(((String)id));
			//String uid=(String)id;
		return service.getUserById(uid).get();
		}
		catch(Exception e) {
			return new User();
		}
	}

}
