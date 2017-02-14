package com.core.algos;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int n = sc.nextInt();
		int[] val = new int[n];
		int[] weights = new int[n];
		for(int i = 0 ; i < n ;i ++){
			val[i] = sc.nextInt();
		}
		for(int i = 0 ; i < n ;i ++){
			weights[i] = sc.nextInt();
		}
		computeMaxProf(val, weights, w);
	}

	private static void computeMaxProf(int[] val, int[] weights, int w) {
		// TODO Auto-generated method stub
		int[][] k = new int[w+1][val.length+1];
		for(int i = 0 ; i <= w ; i++){
			k[i][0] = 0;
		}
		for(int i = 0 ; i <= val.length ; i++){
			k[0][i] = 0;
		}
		for(int i = 1 ; i <= w ; i++){
			for(int j = 1 ; j <= val.length ; j++){
				if(i>=weights[j-1]){
					k[i][j] =Integer.max(k[i][j-1], val[j-1] + k[i-weights[j-1]][j-1]);
				}
				else{
					k[i][j] = k[i][j-1];
				}
			}
		}
		System.out.println(k[w][val.length]);
		
	}

}
