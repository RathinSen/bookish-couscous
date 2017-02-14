package com.core.revision;

import java.util.Scanner;

public class LCSAgain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		lcs(a,b);
		sc.close();
	}

	private static void lcs(String a, String b) {
		// TODO Auto-generated method stub
		int[][] l = new int[a.length()+1][b.length()+1];
		for(int i = 1 ; i <=a.length();i++){
			for(int j = 1;j<=b.length();j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					l[i][j] = l[i-1][j-1]+1;
				}else{
					l[i][j] = Integer.max(l[i-1][j], l[i][j-1]);
					
				}
			}
		}
		printLCS(l,a,b);
		System.out.println(l[a.length()][b.length()]);
	}

	private static void printLCS(int[][] l, String a, String b) {
		// TODO Auto-generated method stub
		int i = a.length();
		int j = b.length();
		StringBuffer sb = new StringBuffer();
		while(i>0 && j>0){
			if(a.charAt(i-1) == b.charAt(j-1)){
				sb.insert(0, a.charAt(i-1));
				i--;
				j--;
			}
			else{
				if(l[i][j-1]>l[i-1][j]){
					j--;
				}else{
					i--;
				}
			}
		}
		System.out.println(sb);
	}

}
