package com.core.java.features.fucntionInterface;

public interface Lion {

	 default void sound(){
		System.out.println("Rawr");
	}
	
	 abstract void jump();
}
