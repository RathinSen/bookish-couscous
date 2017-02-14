package com.core.revision;

import java.util.Scanner;

public class BinomialCoeffN2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int k =sc.nextInt();
		findBinomial(n,k);
		sc.close();
	}

	private static void findBinomial(int n, int k) {
		// TODO Auto-generated method stub
		int[][] l = new int[n+1][k+1];
		for(int i = 0 ; i <= n ;i++){
			l[i][0] =1;
		}
		for(int i = 1 ; i<=n;i++){
			for(int j = 1 ; j<=k; j++){
				if(j<i){
					l[i][j] = l[i-1][j-1] + l[i-1][j];
				}
				else if(i==j){
					l[i][j] =1;
				}
			}
		}
		System.out.println(l[n][k]);
	}

}
