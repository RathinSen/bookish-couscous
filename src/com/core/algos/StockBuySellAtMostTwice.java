package com.core.algos;

import java.util.Scanner;

public class StockBuySellAtMostTwice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i ++){
			a[i] = sc.nextInt();
		}
		sc.close();
		findMaxProfit(a);

	}

	private static void findMaxProfit(int[] a) {
		// TODO Auto-generated method stub
		int max = 0;
		for(int i = 1 ; i < a.length ; i++){
			max = Integer.max(max, calculateMaxProfit(0,i,a)+calculateMaxProfit(i+1,a.length-i,a));
 		}
		System.out.println(max);
	}

	private static int calculateMaxProfit(int i, int i2, int[] a) {
		// TODO Auto-generated method stub
		int smallest = Integer.MAX_VALUE;
		int diff = 0;
		for(int j = i; j<=i2; j++){
			if(a[j]<smallest){
				smallest =a[j];
			}else{
				diff = Integer.max(diff, a[j] - smallest);
			}
		}
		return diff;
	}

}
