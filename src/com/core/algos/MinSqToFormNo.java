package com.core.algos;

import java.util.Scanner;

public class MinSqToFormNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int lim = (int) Math.sqrt(n);
		int[] a = new int[lim+1];
		for(int i = 0 ; i <=lim ; i++){
			a[i] = (int) Math.pow(i, 2);
		}
		//findMinSquares(n, a);
		findMinSquaresGFG(n, a);
		sc.close();
	}

	private static void findMinSquaresGFG(int n, int[] a) {
		// TODO Auto-generated method stub
		int[] l = new int[n+1];
		l[0] = 0; l[1] = 1; l[2] = 2; l[3] = 3;
		for(int i = 4 ; i <=n ;i++){
			l[i] = i;
			int j = 2;
			while(j*j<=i){
				l[i] = Integer.min(l[i],1+l[i - (j*j)]);
				j++;
			}
		}
		System.out.println(l[n]);
		
	}

	private static void findMinSquares(int n, int[] a) {
		// TODO Auto-generated method stub
		int[][] l = new int[n+1][a.length];
		for(int i = 1 ; i <=n ;i++ ){
			l[i][0] = Integer.MAX_VALUE;
		}
		for(int i = 1; i <=n;i++){
			for(int j = 1 ; j < a.length;j++){
				if(i-a[j]>=0){
					l[i][j] = Integer.min(l[i-a[j]][j]+1,l[i][j-1]);
				}
				else{
					l[i][j] = l[i][j-1];
				}
			}
		}
		System.out.println(l[n][a.length-1]);
	}

}
