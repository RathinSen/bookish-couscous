package com.core.algos;

import java.util.Scanner;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ;i ++){
			a[i] = sc.nextInt();
			
		}
		computeSubSum(s, a);
	}

	private static void computeSubSum(int s, int[] a) {
		// TODO Auto-generated method stub
		boolean[][] l = new boolean[s+1][a.length+1];
		for(int i = 0 ; i <= s;i++){
			l[i][0] = false;
		}
		for(int i = 0 ; i <= a.length;i++){
			l[0][i] = true;
		}
		for(int i = 1 ; i <=s ; i++){
			for(int j = 1 ; j <=a.length;j++){
				if(i-a[j-1]>=0){
					l[i][j] = l[i-a[j-1]][j-1] || l[i][j-1];
				}
				else
				{
					l[i][j] = l[i][j-1];
				}
			}
		}
		System.out.println(l[s][a.length]);
	}

}
