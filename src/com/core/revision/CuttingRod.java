package com.core.revision;

import java.util.Scanner;

public class CuttingRod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int[] a  = new int[n];
		for(int i = 0 ; i < n;i++){
			a[i]  = sc.nextInt();
		}
		findMaxProfit(a);
		sc.close();
	}

	private static void findMaxProfit(int[] a) {
		// TODO Auto-generated method stub
		int[][] l = new int[a.length+1][a.length+1];
		for(int i = 1 ; i <=a.length;i++){
			for(int j = 1 ; j<=a.length;j++){
				if(i-j>=0){
					l[i][j] = Integer.max(l[i][j-1], l[i-j][j]+a[j-1]);
				}else{
					l[i][j] = l[i][j-1];
				}
			}
		}
		System.out.println(l[a.length][a.length]);
	}

}
