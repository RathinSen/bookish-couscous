package com.core.algos;

import java.util.Scanner;

public class LPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(lps(s));
	}

	private static int lps(String s) {
		// TODO Auto-generated method stub
		int ans = 1;
		int[][] l = new int[s.length()][s.length()];
		for(int i = 0 ; i < s.length() ;i++){
			l[i][i] = 1;
		}
		
		for(int len=2;len<=s.length();len++){
			for(int i = 0 ; i < s.length() - len + 1; i++){
				int j = i+len-1;
				if(len==2){
					if(s.charAt(i) == s.charAt(j)){
						l[i][j] = 2;
					}
					else{
						l[i][j] = 1;
					}
				}
				else{
					if(s.charAt(i) == s.charAt(j)){
						l[i][j] = l[i+1][j-1] +2;
					}
					else{
						l[i][j] = Integer.max(l[i+1][j],l[i][j-1]);
					}
				}
			}
		}
		//System.out.println(l[s.length()-1][s.length()-1]);
		ans = l[0][s.length()-1];
		return ans;
	}

}
