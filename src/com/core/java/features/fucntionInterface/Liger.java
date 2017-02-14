package com.core.java.features.fucntionInterface;

public class Liger implements Lion,Tiger{

	public void makeSound(){
		sound();
	}
	
	//@Override
	public void sound(){
		System.out.println("Meow");
		Tiger.bite();
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}
}
