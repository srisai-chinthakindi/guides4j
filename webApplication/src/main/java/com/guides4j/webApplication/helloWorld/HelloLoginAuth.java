package com.guides4j.webApplication.helloWorld;

import org.springframework.stereotype.Service;

@Service
public class HelloLoginAuth {
	
	public boolean isValidUser(String userName , String password) {
		
		boolean name = userName.equalsIgnoreCase("gopi");
		boolean pass = password.equalsIgnoreCase("s123");
		
		return name && pass;
	}

}
