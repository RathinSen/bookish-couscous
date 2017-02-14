package com.core.algos;

import java.util.Scanner;

public class PalindromSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		longestPalindrome(s);
	}

	private static void longestPalindrome(String s) {
		// TODO Auto-generated method stub
		int max = 1;
		boolean[][] b = new boolean[s.length()][s.length()];
		for(int i = 0 ; i < s.length();i++){
			b[i][i] = true;
		}
		String sub = "";
		for(int len = 2 ; len <= s.length(); len++){
			for(int i = 0 ; i <s.length()-len+1;i++){
				int j = i+len-1;
				if(len==2){
					if(s.charAt(i)==s.charAt(j)){
						b[i][j]=true;
					}else{
						b[i][j] = false;
					}
				}
				else{
					if(s.charAt(i)==s.charAt(j) && b[i+1][j-1]){
						b[i][j] = true;
					}
					else{
						b[i][j]=false;
					}
				}
				if(max<len && b[i][j])
				{
					max=len;
					sub = s.substring(i,j+1);
				}
			}
		}
		System.out.println(sub);
	}

}
