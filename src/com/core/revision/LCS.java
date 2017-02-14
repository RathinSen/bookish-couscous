package com.core.revision;

import java.util.Scanner;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a  = sc.next();
		String b  = sc.next();
		findlcs(a,b);
		sc.close();
		
	}

	private static void findlcs(String a, String b) {
		// TODO Auto-generated method stub
		int[][] l = new int[a.length()+1][b.length()+1];
		for(int i =1; i <=a.length();i++){
			for(int j = 1; j<=b.length() ; j++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					l[i][j] = 1+l[i-1][j-1];
				}else{
					l[i][j] = Integer.max(l[i][j-1], l[i-1][j]);
				}
			}
		}
		
		
		System.out.println(l[a.length()][b.length()]);
	}

}
