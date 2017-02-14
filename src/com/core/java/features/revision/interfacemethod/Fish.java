package com.core.java.features.revision.interfacemethod;

public interface Fish {
	
	default void swim(){
		System.out.println("swimming");
	}

}
