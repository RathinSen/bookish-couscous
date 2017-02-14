package com.core.java.features.revision.lambda;

public interface Math {
	
	public void operate(int x, int y);
	default public void anotheroperate(int x , int y){
		System.out.println("anotheroperate");
	}
}
