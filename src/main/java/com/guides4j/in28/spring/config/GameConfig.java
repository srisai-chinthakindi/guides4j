package com.guides4j.in28.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.guides4j.in28.spring.gameDemo.Contra;
import com.guides4j.in28.spring.gameDemo.Game;
import com.guides4j.in28.spring.gameDemo.GameRunner;
import com.guides4j.in28.spring.gameDemo.SuperMario;

@Configuration
public class GameConfig {
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
	
	
}
