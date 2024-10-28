package com.guides4j.in28.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guides4j.in28.spring.config.GameConfig;
import com.guides4j.in28.spring.gameDemo.GameRunner;

public class GameRunnerSpring {
	public static void main(String[] args) {
//		var ctx = new AnnotationConfigApplicationContext(GameConfig.class);
//		Resource leak: 'ctx' is never closed so we can use tryWithResources
		
		try(var ctx = new AnnotationConfigApplicationContext(GameConfig.class)){
			
			ctx.getBean(GameRunner.class).run();;
			
		}
		
		
	}
}
