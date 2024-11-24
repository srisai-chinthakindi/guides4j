package com.guides4j.webApplication.todoApplication;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ToDoSpringSecurityConfiguration {
	/* default version 2.1.0
	 * Here we used withDefaultPasswordEncoder which is deprecated so we opted to use a Strong hashing alogoirth i,e BCryptyEncoder()
		@Bean
		public InMemoryUserDetailsManager userManager() {
			var userDetails = User.withDefaultPasswordEncoder()
								.username("gopi")
								.password("s123").
								build();
			return new InMemoryUserDetailsManager(userDetails);
		}
	*/
	
	
	
	@Bean
	public InMemoryUserDetailsManager userManager() {
		 
		UserDetails userDetails1 = createNewUser("gopi", "s123");
		UserDetails userDetails2 = createNewUser("srisai", "256124");
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}

	private UserDetails createNewUser(String UserName, String password) {
		Function<String, String> encoder = encrypty -> bcryptyEncoder().encode(encrypty);
		UserDetails userDetails = User.builder()
							.passwordEncoder(encoder)
							.username(UserName)
							.password(password)
							.roles("USER","ADMIN")
							.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder bcryptyEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
