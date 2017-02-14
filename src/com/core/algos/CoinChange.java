package com.core.algos;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int s = sc.nextInt();
			int[] sn = new int[s];
			for(int i=0 ;i<s;i++){
				sn[i] = sc.nextInt();
			}
			
			System.out.println(comWays(n,sn));
		}
		sc.close();
	}

	private static int comWays(int n, int[] sn) {
		// TODO Auto-generated method stub
		int ans = 0 ;
		int[][] w = new int[n+1][sn.length+1];
		for(int i = 1 ; i <= sn.length; i++){
			w[0][i] = 1;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= sn.length; j++){
				if(i >= sn[j-1]){
					w[i][j] = w[i-sn[j-1]][j] + w[i][j-1];
				}
				else{
					w[i][j] = w[i][j-1];
				}
			}
		}
		ans = w[n][sn.length];
		return ans;
	}

}
