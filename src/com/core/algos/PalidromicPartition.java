package com.core.algos;

import java.util.Scanner;

public class PalidromicPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		minCuts(s);
		sc.close();
	}

	private static void minCuts(String s) {
		// TODO Auto-generated method stub
		int[][] l = new int[s.length()][s.length()];
		boolean[][] p = new boolean[s.length()][s.length()];
		for(int i = 0 ; i < s.length();i++){
			l[i][i] = 0;
			p[i][i] = true;
		}
		for(int len = 2; len <=s.length();len++){
			for(int i = 0 ; i < s.length()-len+1;i++){
				int j = i+len-1;
				if(len==2){
					if(s.charAt(i) == s.charAt(j)){
						l[i][j] = 0;
						p[i][j] = true;
					}
					else
					{
						l[i][j] = 1;
						p[i][j] = false;
					}
				}
				else{
					if(s.charAt(i) == s.charAt(j) && p[i+1][j-1]){
						l[i][j] = 0;
						p[i][j] = true;
					}
					else{
						p[i][j] = false;
						l[i][j] = Integer.MAX_VALUE;
						for(int k = i; k < j ; k++){
							l[i][j]  = Integer.min(l[i][j], l[i][k]+l[k+1][j]+1);
						}
					}
				}
			}
		}
		System.out.println(l[0][s.length()-1]);
	}

}
