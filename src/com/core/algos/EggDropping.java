package com.core.algos;

import java.util.Scanner;

public class EggDropping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		sc.close();
		findMin(n,e);
	}

	private static void findMin(int n, int e) {
		// TODO Auto-generated method stub
		int[][] l = new int[n+1][e];
		for(int i = 0 ; i < e;i++){
			l[0][i] = 0;
		}
		for(int i = 1; i <=n; i++){
			for(int j = 0 ; j < e;j++){
				if(j==0 || i==1){
					l[i][j]=i;
				}
				else{
					l[i][j] = Integer.MAX_VALUE;
					for(int k = 1 ; k < i ;k++){
						l[i][j] = Integer.min(l[i][j],1+ Integer.max(l[k-1][j-1],l[i-k][j]));
					}
				}
			}
		}
		System.out.println(l[n][e-1]);
	}

}
