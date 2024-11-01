package com.guides4j.in28.spring.gameDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperMario implements Game{

	@Override
	public void up() {
		System.out.println("Break Roof");
		
	}

	@Override
	public void right() {
		System.out.println("Accelerate");
		
	}

}
