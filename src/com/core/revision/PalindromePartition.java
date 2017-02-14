package com.core.revision;

import java.util.Scanner;

public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
		findMinPart(s);
		sc.close();
	}

	private static void findMinPart(String s) {
		// TODO Auto-generated method stub
		int[][] l = new int[s.length()][s.length()];
		for(int  len = 2 ; len <= s.length();len++ ){
			for(int i = 0 ; i < s.length()-len+1;i++){
				int j = i+len-1;
				if(len==2){
					if(s.charAt(i)==s.charAt(j)){
						l[i][j] = 0;
					}else{
						l[i][j] = 1;
					}
				}
				else{
					if(s.charAt(i)==s.charAt(j) && l[i+1][j-1]==0){
						l[i][j] = 0;
					}
					else{
						l[i][j] = Integer.MAX_VALUE;
						for(int k = i ; k<j;k++){
							l[i][j] = Integer.min(l[i][j], 1+l[i][k]+l[k+1][j]);
						}
					}
					
				}
			}
		}
		System.out.println(l[0][s.length()-1]);
	}	

}
