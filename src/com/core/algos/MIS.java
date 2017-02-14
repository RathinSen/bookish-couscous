package com.core.algos;

import java.util.Scanner;

public class MIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ;i++){
			a[i] = sc.nextInt();
		}
		performMIS(a);
		sc.close();
	}

	private static void performMIS(int[] a) {
		// TODO Auto-generated method stub
		int[] mis = new int[a.length];
		for(int i = 0 ;i < a.length ; i++){
			mis[i] =a [i];
		}
		int max_sum = a[0];
		for(int i = 1 ; i < a.length ;i++){
			for(int j = 0 ; j < i ; j++){
				if(a[i] > a[j] && mis[j]+a[i] > mis[i]){
					mis[i] = mis[j]+a[i];
				}
				max_sum=Integer.max(max_sum, mis[i]);
			}
			
		}
		System.out.println(max_sum);
		
	}

}
