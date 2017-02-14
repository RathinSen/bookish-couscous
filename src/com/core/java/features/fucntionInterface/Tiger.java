package com.core.java.features.fucntionInterface;

public interface Tiger {

	default void sound(){
		System.out.println("Grrrrr");
	}
	
	static void bite(){
		System.out.println("BITE");
	}
}
