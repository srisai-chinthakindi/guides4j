package com.guides4j.in28.spring.gameDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContra")
public class Contra implements Game{

	@Override
	public void up() {
		System.out.println("Jump");	
	}

	@Override
	public void right() {
		System.out.println("Shoot");
	}

}
