package com.core.algos;

import java.util.Scanner;

public class MaxSizeSquareSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int[][] matrix = new int[w][h];
		for(int i = 0 ; i < w; i++){
			for(int j = 0 ; j < h ;j ++){
				matrix[i][j] = sc.nextInt();
			}
		}
		findMax(matrix, w, h);
		sc.close();
	}

	private static void findMax(int[][] a, int w, int h) {
		// TODO Auto-generated method stub
		int max = 1;
		for(int i = 1 ; i < w; i++){
			for(int j = 1 ; j < h ;j ++){
				if(a[i-1][j-1] > 0 && a[i-1][j] > 0 && a[i][j-1]>0){
					a[i][j] = 1+Integer.min(a[i-1][j-1], Integer.min(a[i-1][j], a[i][j-1]));
					max = Integer.max(max, a[i][j]);
				}
			}
		}
		System.out.println(max);
		
	}

}
