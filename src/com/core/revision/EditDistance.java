package com.core.revision;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner csc = new Scanner(System.in);
		String a  = csc.next();
		String b  = csc.next();
		findEditDistance(a,b);
		csc.close();
	}

	private static void findEditDistance(String a, String b) {
		// TODO Auto-generated method stub
		int[][] l = new int[a.length()+1][b.length()+1];
		for(int i = 0 ; i <= a.length();i++){
			l[i][0] = i;
		}
		for(int i = 0 ; i <= b.length();i++){
			l[0][i] = i;
		}
		for(int i = 1; i <=a.length();i++){
			for(int j = 1; j<=b.length();j++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					l[i][j] = l[i-1][j-1];
				}
				else{
					l[i][j] = 1+Integer.min(l[i][j-1], Integer.min(l[i-1][j],l[i-1][j-1]));
				}
			}
		}
		System.out.println(l[a.length()][b.length()]);
	}

}
