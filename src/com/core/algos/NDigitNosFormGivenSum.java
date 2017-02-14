package com.core.algos;

import java.util.Arrays;
import java.util.Scanner;

public class NDigitNosFormGivenSum {

	static int[][] lookup = new int[101][50001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		for(int[] row : lookup){
			Arrays.fill(row, -1);
		}
		findNosWrapper(n,sum);
		sc.close();
	}

	private static void findNosWrapper(int n, int sum) {
		// TODO Auto-generated method stub
		int ans=0;
		for(int i = 1; i <= 9 ; i++){
			if(sum-i>=0){
				ans+=findways(n-1,sum-i);
			}
		}
		System.out.println(ans);
	}

	private static int findways(int n, int sum) {
		// TODO Auto-generated method stub
		
		int ans = 0;
		if(lookup[n][sum]!=-1){
			return lookup[n][sum];
		}
		else if(n==0){
			if(sum==0){
				return 1;
			}
			else{
				return 0;
			}
		}
		else{
			for(int i = 0 ; i <=9 ;i++){
				if(sum-i>=0){
					ans+=findways(n-1,sum-i);
				}
			}
			lookup[n][sum] = ans;
			return ans;
		}
	}

}
