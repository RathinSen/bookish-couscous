package com.core.algos;

import java.util.Scanner;

public class MinCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int v = sc.nextInt();
		String[] tkns = sc.next().trim().split(",");
		int[] a = new int[tkns.length];
		for(int i = 0 ; i < tkns.length ; i++){
			a[i] = Integer.parseInt(tkns[i]);
		}
		minCoinChange(a,v);
		sc.close();
	}

	private static void minCoinChange(int[] a, int v) {
		// TODO Auto-generated method stub
		int[][] l = new int[v+1][a.length];
		for(int i = 0 ; i < a.length; i++){
			l[0][i] = 0;
		}
		for(int i = 1 ; i <= v ; i++){
			for(int j = 0; j < a.length;j++){
				if(i-a[j]>=0){
					if(l[i-a[j]][j]!=Integer.MAX_VALUE)
						l[i][j] = l[i-a	[j]][j]+1;
					else
						l[i][j] = Integer.MAX_VALUE;
				}
				else{
					l[i][j] = Integer.MAX_VALUE;
				}
				if(j>0){
					l[i][j] = Integer.min(l[i][j-1], l[i][j]);
				}
			}
		}
		if(l[v][a.length-1]==Integer.MAX_VALUE){
			l[v][a.length-1] = 0;
		}
		System.out.println(l[v][a.length-1]);
	}

}
