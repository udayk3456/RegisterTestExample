package com.app.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@RestController
public class InterceptorClass extends HandlerInterceptorAdapter{
	
	private static String random=null;
	
	@PostMapping("/salt")
	public String test(@RequestBody String encoded){
		String password=new String(Base64.decodeBase64(encoded.getBytes()));
		if(password.equals("Uday_Koleti_Test"))
		{
			InterceptorClass.random=this.random();
			return random;
		}
		else {
			return null;
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String[] s1=request.getRequestURI().split("/");
		
		if(InterceptorClass.random!=null && (InterceptorClass.random.equals(s1[1]))) {
			return true;
		}else {
			response.sendError(403,"Not allowed");
			return false;
		}
	}
	public String random() {
		char[] ch=new char[10];
		Random rand=new Random();
		for(int i=0;i<10;i++) {
			int j=rand.nextInt(3);
			if(j==0) {ch[i]=(char)(rand.nextInt(10)+48);}
			if(j==1) {ch[i]=(char)(rand.nextInt(26)+65);}
			if(j==2) {ch[i]=(char)(rand.nextInt(26)+97);}
		}
		String s=String.valueOf(ch);
		return s;
	}
	

}
