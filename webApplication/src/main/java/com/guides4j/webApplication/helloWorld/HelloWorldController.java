package com.guides4j.webApplication.helloWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@Autowired
	HelloLoginAuth helloLoginAuth;

	private Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping("hello")
	@ResponseBody
	public String sayHello() {
		return "Hello Web Application Development";
	}

	@RequestMapping("hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		int id = 1;

		String htmlTextTest = """
				<html>
				<head>
						<title>Hello Html</title>
				</head>
				<body>
						<h2>Hello Web Application Development Experiments</h2>
				</body>

				</html>

						""";
		return htmlTextTest;
	}

	@RequestMapping("hello-jsp")
	public String sayHelloJsp() {
		return "sayHelloJsp";
	}

/* Default -- In Prototype1

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String gotoLogin() {
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginToWelcome(@RequestParam String name, @RequestParam String pass, ModelMap map) {

//	    we can also add authentication as well 
		if (helloLoginAuth.isValidUser(name, pass)) {
			map.put("userName", name);
			return "welcomeUser";
		}
		map.put("loginErrorMessage", "Invalid Credentials");
		return "login";

	}
 
 */

}
