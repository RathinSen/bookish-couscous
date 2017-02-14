package com.core.revision;

import java.util.Scanner;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ;j++){
				a[i][j] = sc.nextInt();
			}
		}
		minCost(a,n,m);
		sc.close();
	}

	private static void minCost(int[][] a, int n, int m) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				if(i==0 && j==0){
					continue;
				}
				else if(i==0){
					a[i][j] += a[i][j-1]; 
				}
				else if(j==0){
					a[i][j] += a[i-1][j];
				}
				else{
					a[i][j] += Integer.min(a[i][j-1], Integer.min(a[i-1][j], a[i-1][j-1]));
				}
			}
		}
		System.out.println(a[n-1][m-1]);
	}

}
