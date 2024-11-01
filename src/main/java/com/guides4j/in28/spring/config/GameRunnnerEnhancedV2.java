package com.guides4j.in28.spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.guides4j.in28.spring.gameDemo.Contra;
import com.guides4j.in28.spring.gameDemo.Game;
import com.guides4j.in28.spring.gameDemo.GameRunner;
import com.guides4j.in28.spring.gameDemo.SuperMario;

@Configuration
@ComponentScan("com.guides4j.in28.spring.gameDemo")
public class GameRunnnerEnhancedV2 {
 
 
	public static void main(String[] args) {
 
			try(var ctx = new AnnotationConfigApplicationContext(GameRunnnerEnhancedV2.class)){
				ctx.getBean(GameRunner.class).run();
 
			}
			
//			Here we can observe that there is no Boiler Template Code to Create the Objects 
//			Spring Automatically creates the object with this Component inOrder to avoid conflicts we can use @Primary an @Qualifier
/*
 *  even without annotating GameRunner with @Component, 
 *  Spring knows how to inject it because the dependency (Game) 
 *  exists and matches a @Component (in this case, Contra).
 *  This approach supports loose coupling, where any Game
 *   implementation can be injected into GameRunner without modifying the GameRunner class.
 */
	}
	

}
