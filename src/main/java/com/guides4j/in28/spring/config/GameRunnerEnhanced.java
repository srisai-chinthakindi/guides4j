package com.guides4j.in28.spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.guides4j.in28.spring.gameDemo.Contra;
import com.guides4j.in28.spring.gameDemo.Game;
import com.guides4j.in28.spring.gameDemo.GameRunner;
import com.guides4j.in28.spring.gameDemo.SuperMario;

@Configuration
public class GameRunnerEnhanced {
	@Bean
	public SuperMario getSuperMario() {
		return new SuperMario();		
	}
	
	@Bean
	public Contra getContra() {
		return new Contra();		
	}
	
	@Bean
	public GameRunner gameRunner() {
		Game game = getContra();
		return new GameRunner(game);
	}
	public static void main(String[] args) {
		try(var ctx = new AnnotationConfigApplicationContext(GameRunnerEnhanced.class)){
			ctx.getBean(GameRunner.class).run();
//			yes we might be wondering that we are the one the who is creating the object even in the Enhanced Version
//			though we managed to reduce the number of Lines but here where the @ component comes into play to create the Object and Wire Them
//			@see GameRunnnerEnhancedV2
		}
	}
}
