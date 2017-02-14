package com.core.revision;

import java.util.Scanner;

public class BinoCoeff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		calWays(n,k);
		sc.close();
	}

	private static void calWays(int n, int k) {
		// TODO Auto-generated method stub
		int[][] l = new int[n+1][k+1];
		for(int i = 0 ; i <= n ; i++){
			for(int j = 0 ; j<=Integer.min(i, k);j++){
				if(i==j || j==0){
					l[i][j] = 1;
				}else{
					l[i][j] = l[i-1][j-1] + l[i-1][j];
				}
			}
		}
		System.out.println(l[n][k]);
	}

}
