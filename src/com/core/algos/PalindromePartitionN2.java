package com.core.algos;

import java.util.Scanner;

public class PalindromePartitionN2 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		minPart(sc.next());
	}

	private static void minPart(String s) {
		// TODO Auto-generated method stub
		boolean[][] p = new boolean[s.length()][s.length()];
		for(int i = 0 ;i < s.length();i++){
			p[i][i] = true;
		}
		for(int len  =2 ; len<=s.length();len++){
			for(int i = 0 ; i < s.length()-len+1;i++){
				int j = i + len -1;
				if(len==2){
					if(s.charAt(i) == s.charAt(j)){
						p[i][j] =true;
					}
					else
						p[i][j] = false;
				}
				else{
					if(s.charAt(i) == s.charAt(j) && p[i+1][j-1]){
						p[i][j] =true;
					}else{
						p[i][j] =false;
					}
				}
			}
		}
		int[] m  = new int[s.length()];
		for(int i = 0; i < s.length() ;i++){
			if(p[0][i]){
				m[i] = 0;
			}
			else{
				m[i] = Integer.MAX_VALUE;
				for(int j = 0 ; j < i ; j++){
					if(p[j+1][i] && 1+m[j]<m[i]){
						m[i] = 1+ m[j];
					}
				}
			}
		}
		System.out.println( m[s.length()-1]);
 		
	}
}
