package com.core.algos;

import java.util.Scanner;

public class LongestEvenLengthSubstringSameSumInBothHalves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] tkns = sc.next().trim().split("");
		int[] a  = new int[tkns.length];
		for(int i = 0 ; i < tkns.length ; i ++){
			a[i] = Integer.parseInt(tkns[i]);
		}
		calLongest(a);
		sc.close();
	}

	private static void calLongest(int[] a) {
		// TODO Auto-generated method stub
		int maxLen = 0;
		int[][] sum = new int[a.length][a.length];
		for(int i = 0 ; i < a.length ; i++){
			sum[i][i] = a[i] ;
		}
		for(int len = 2 ; len<=a.length; len++){
			for(int i = 0 ; i < a.length - len+1 ;i++){
				int j = i+len-1;
				int half = i + len/2 - 1;
				sum[i][j] = sum[i][half] + sum[half+1][j];
				if(len%2==0 && sum[i][half]==sum[half+1][j]){
					maxLen = Integer.max(maxLen, len);
				}
			}
		}
		
		
		System.out.println(maxLen);
	}

}
