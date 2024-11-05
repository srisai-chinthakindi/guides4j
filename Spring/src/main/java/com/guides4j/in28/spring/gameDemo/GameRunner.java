package com.guides4j.in28.spring.gameDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
//	No it is loosly coupled beacuse the Game is Geniric and there is No need to Change the Code for the Game Runnner
//	Sice it can allow any Game that implements Game
//	Before it is Tightly Coupled to Particular Game like SuperMario or Contra ..
	Game game;
	public GameRunner(@Qualifier("SuperContra") Game game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println(game.getClass().getSimpleName() + " is Running");
		game.up();
		game.right();
	}
}
