package com.guides4j.in28.spring.gameDemo;

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
