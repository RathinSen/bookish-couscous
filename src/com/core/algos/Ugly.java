package com.core.algos;

import java.util.Scanner;

public class Ugly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		callUgly(n);
		sc.close();
	}

	private static void callUgly(int n) {
		// TODO Auto-generated method stub
		int[] ugly = new int[n];
		ugly[0] = 1; 
		int pointer_2 = 0;
		int pointer_3 = 0;
		int pointer_5 = 0;
		for(int i = 1 ; i < n ; i++){
			ugly[i] = Integer.min(ugly[pointer_2]*2, Integer.min(ugly[pointer_3]*3, ugly[pointer_5]*5));
			if(ugly[i] == ugly[pointer_2]*2){
				pointer_2++;
			}
			if(ugly[i] == ugly[pointer_3]*3){
				pointer_3++;
			
			}if(ugly[i]==ugly[pointer_5]*5){
				pointer_5++;
			}
		}
		System.out.println(ugly[n-1]);
	}

}
