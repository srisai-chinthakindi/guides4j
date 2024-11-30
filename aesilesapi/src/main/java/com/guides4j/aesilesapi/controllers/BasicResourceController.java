package com.guides4j.aesilesapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.guides4j.aesilesapi.models.DummyUser;
import com.guides4j.aesilesapi.models.FakeDataUser;
import com.guides4j.aesilesapi.models.NameObject;

@RestController
public class BasicResourceController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to API developement";
	}
	
	@GetMapping("/hello/{NameObject}")
	public String sayHelloPathVariable(@PathVariable String NameObject) {
		return"""
				<h1> guides4J API Development</h1>
				<hr>
				Heyy  				
			  """ + NameObject;
	}
	
	
//	 URI versioning
	@GetMapping("/v1/person")
	public DummyUser getFirstVersionOfPerson() {
		return new DummyUser("Bob", "Charlie");
	}

	@GetMapping("/v2/person")
	public FakeDataUser getSecondVersionOfPerson() {
		return new FakeDataUser(new NameObject("Bob","Charlie"));
	}
	
//	Parameter Versioning
	@GetMapping(path = "/person", params = "version=1")
	public DummyUser getFirstVersionOfPersonRequestParameter() {
		return new DummyUser("Bob","Charlie");
	}

	
	@GetMapping(path = "/person", params = "version=2")
	public FakeDataUser getSecondVersionOfPersonRequestParameter() {
		return new FakeDataUser(new NameObject("Bob", "Charlie"));
	}
	
//	Header Accept Type Versioning

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public DummyUser getFirstVersionOfPersonRequestHeader() {
		return new DummyUser("Bob","Charlie");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public FakeDataUser getSecondVersionOfPersonRequestHeader() {
		return new FakeDataUser(new NameObject("Bob", "Charlie"));
	}
	
//	mediaType Versioning

	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public DummyUser getFirstVersionOfPersonAcceptHeader() {
		return new DummyUser("Bob","Charlie");
	}

	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public FakeDataUser getSecondVersionOfPersonAcceptHeader() {
		return new FakeDataUser(new NameObject("Bob", "Charlie"));
	}
}
