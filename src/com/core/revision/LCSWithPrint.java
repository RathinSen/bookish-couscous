package com.core.revision;

import java.util.Scanner;

public class LCSWithPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		findLCS(a,b);
		sc.close();
	}

	private static void findLCS(String a, String b) {
		// TODO Auto-generated method stub
		int[][] l = new int[a.length()+1][b.length()+1];
		for(int i =1 ; i <= a.length();i++){
			for(int j = 1 ; j<=b.length();j++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					l[i][j] = 1+l[i-1][j-1];
				}
				else{
					l[i][j] = Integer.max(l[i-1][j], l[i][j-1]);
				}
			}
		}
		int i = a.length();
		int j= b.length();
		StringBuffer sb = new StringBuffer();
		while(i>0 && j>0){
			if(a.charAt(i-1) == b.charAt(j-1)){
				sb = sb.insert(0, a.charAt(i-1));
				i--;
				j--;
				
			}
			else if(l[i-1][j]>l[i][j-1]){
				i--;
			}
			else{
				j--;
			}
		}
		System.out.println(sb.toString());
	}

}
