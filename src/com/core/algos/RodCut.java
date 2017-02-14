package com.core.algos;

import java.util.Scanner;

public class RodCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0){
			int[] val = new int[n];
			for(int i = 0 ; i < n ; i++){
				val[i] = sc.nextInt();
			}
			findMaxProfit(val);
		}
		sc.close();
	}

	private static void findMaxProfit(int[] val) {
		// TODO Auto-generated method stub
		int[][] l = new int[val.length+1][val.length+1];
		for(int i = 0 ; i <=val.length;i++){
			l[0][i] = 0;
		}
		for(int i = 1 ; i <=val.length;i++){
			l[i][0] = val[i-1];
		}
		for(int i = 1 ; i <= val.length ;i++){
			for(int j = 1; j<= val.length ;j++){
				if(i-j>=0){
					l[i][j] = Integer.max(l[i][j-1], val[j-1]+l[i-j][j]);
				}
				else{
					l[i][j] = l[i][j-1];
				}
			}
		}
	System.out.println(l[val.length][val.length]);
	}

}
