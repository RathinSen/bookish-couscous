package com.core.revision;

import java.util.Scanner;

public class EggDropping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		findMintries(n,e);
		sc.close();
	}

	private static void findMintries(int n, int e) {
		// TODO Auto-generated method stub
		int[][] l = new int[e+1][n+1];
		for(int i  = 1 ; i <= e;i++){
			for(int j = 1; j<=n ; j++){
				if(i==1){
					l[i][j] = j;
				}else{
					l[i][j] = Integer.MAX_VALUE;
					for(int k = 1 ; k <= j ;k++ ){
						l[i][j] = Integer.min(l[i][j], 1+Integer.max(l[i-1][k-1], l[i][j-k]));
					}
				}
			}
		}
		System.out.println(l[e][n]);
	}

}
