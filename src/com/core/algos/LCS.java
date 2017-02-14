package com.core.algos;

import java.util.Scanner;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t  = sc.nextInt();
		while(t-->0){
			String a = sc.next();
			String b = sc.next();
			System.out.println(computeLcs(a,b));
			
		}
	}

	private static int computeLcs(String a, String b) {
		// TODO Auto-generated method stub
		int ans = 0;
		int[][] lcs = new int[a.length()+1][b.length()+1];
		for(int i = 0 ; i <= a.length() ; i++){
			lcs[i][0] = 0;
		}
		for(int i = 0 ; i <= b.length() ; i++){
			lcs[0][i] = 0;
		}
		for(int i = 1; i <= a.length();i++){
			for(int j = 1 ; j <= b.length(); j++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1]+1;
				}
				else{
					lcs[i][j] = Integer.max(lcs[i][j-1], lcs[i-1][j]);
							
				}
			}
		}
		ans = lcs[a.length()][b.length()];
		printLCS(a, b, lcs);
		return ans;
	}

	private static void printLCS(String a, String b, int[][] lcs) {
		// TODO Auto-generated method stub
		int i  = a.length();
		int j = b.length();
		StringBuffer sb = new StringBuffer();
		while(i>0 && j>0){
			if(a.charAt(i-1) == b.charAt(j-1)){
				sb.append(a.charAt(i-1));
				i--;
				j--;
			
			}
			else{
				if(lcs[i-1][j]>lcs[i][j-1])
						i--;
				else
						j--;
			}
		}
		
		System.out.println(sb.reverse().toString());
	}

	

}
