package com.core.revision;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		longestPalindrome(s);
		sc.close();
	}

	private static void longestPalindrome(String s) {
		// TODO Auto-generated method stub
		int[][] l = new int[s.length()][s.length()];
		for(int i = 0 ; i <s.length();i++){
			l[i][i] = 1;
		}
		for(int len = 2 ; len<=s.length();len++){
			for(int i = 0 ; i < s.length()-len+1;i++){
				int j = i+len-1;
				if(len==2){
					if(s.charAt(i)==s.charAt(j)){
						l[i][j] = 2;
					}else{
						l[i][j] = 1;
					}
				}
				else{
					if(s.charAt(i) == s.charAt(j)){
						l[i][j] = 2 + l[i+1][j-1];
					}else{
						l[i][j] = Integer.max(l[i][j-1], l[i+1][j]);
					}
				}
			}
		}
		System.out.println(l[0][s.length()-1]);
	}

}
