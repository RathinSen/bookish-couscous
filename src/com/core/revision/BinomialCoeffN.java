package com.core.revision;

import java.util.Scanner;

public class BinomialCoeffN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int k =  sc.nextInt();
		findBi(n,k);
		sc.close();
	}

	private static void findBi(int n, int k) {
		// TODO Auto-generated method stub
		int C = 1;
		for(int i = 1 ; i <=k;i++){
			C = C*(n-i+1)/(i);
		}
		System.out.println(C);
	}

}
