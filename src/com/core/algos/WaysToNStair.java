package com.core.algos;

import java.util.Scanner;

public class WaysToNStair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//System.out.println( count(n));
		System.out.println( countDP(n));
	}

	private static int countDP(int n) {
		// TODO Auto-generated method stub
		int ways = 1;
		int[] a = new int[n+1];
		a[0] = a[1] = 1;
		for(int i=2;i<=n;i++){
			a[i] = a[i-1] + a[i-2];
		}
		return a[n];
	}

	private static int  count(int n) {
		// TODO Auto-generated method stub
		if(n==0 || n==1)
			return 1;
		else{
			return count(n-1) + count(n-2);
		}
	}

}
