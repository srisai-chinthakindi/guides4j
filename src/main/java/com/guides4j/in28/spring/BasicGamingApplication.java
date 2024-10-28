package com.guides4j.in28.spring;

import com.guides4j.in28.spring.gameDemo.Contra;
import com.guides4j.in28.spring.gameDemo.Game;
import com.guides4j.in28.spring.gameDemo.GameRunner;
import com.guides4j.in28.spring.gameDemo.SuperMario;

public class BasicGamingApplication {
	public static void main(String[] args) {
		Game game = new SuperMario();
		GameRunner gameRunner = new GameRunner(game);
		gameRunner.run();
	}
}

