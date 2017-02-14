package com.core.java.features.lambda;

import java.util.Scanner;

public class LambdaMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		MathFunction multiply = () -> {
			return multiply(a,b);
			};
		MathFunction min = () -> Integer.min(a, b);
		System.out.println(multiply.operate());
		System.out.print(min.operate());
		

	}

	private static int multiply(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("FUCKEN HELL");
		return a*b;
	}

}
