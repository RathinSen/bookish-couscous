package com.core.revision;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = sc.next().trim().split(",");
		int[] a = new int[s.length];
		for(int i = 0 ; i < s.length;i++){
			a[i] = Integer.parseInt(s[i].trim());
		}
		coinChange(a,n);
		sc.close();
	}

	private static void coinChange(int[] a, int n) {
		// TODO Auto-generated method stub
		int[][] l = new int[n+1][a.length+1];
		for(int i = 0 ; i <= a.length ;i++){
			l[0][i] = 1;
		}
		for(int i =1 ;i <=n ;i++){
			for(int j = 1; j<=a.length;j++){
				if(i-a[j-1]>=0){
					l[i][j] = l[i][j-1] + l[i-a[j-1]][j];
				}else{
					l[i][j] = l[i][j-1];
				}
			}
		}
		System.out.println(l[n][a.length]);
	}

}
