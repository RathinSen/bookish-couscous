package com.core.java.features.revision.lambda;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		Math add = (x,y) -> System.out.println(x+y);
		Math mod = (x,y) -> {
			int z = x%y;
			System.out.println(z);
		};
		Math multiply = (x,y) -> {System.out.println(x*y);};
		
		multiply(a,b,multiply);
		add(a,b,add);
		mod(a,b,mod);
		sc.close();
	}

	private static void mod(int a, int b, Math mod) {
		// TODO Auto-generated method stub
		mod.operate(a, b);
	}

	private static void add(int a, int b, Math add) {
		// TODO Auto-generated method stub
		add.operate(a, b);
	}

	private static void multiply(int a, int b, Math multiply) {
		multiply.operate(a, b);
	}

}
