package com.core.algos;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			String a = sc.next();
			String b = sc.next();
			System.out.println(computeEditDistance(a,b));
			
		}
	}

	private static int computeEditDistance(String a, String b) {
		// TODO Auto-generated method stub
		int ans = 0 ; 
		int[][] ed = new int[a.length()+1][b.length()+1];
		for(int i = 0 ; i <= a.length();i++){
			ed[i][0] = i;
		}
		for(int i = 0 ; i <= b.length();i++){
			ed[0][i] = i;
		}
		for(int i = 1 ; i <= a.length();i++){
			for(int j = 1 ; j<=b.length();j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					ed[i][j] = ed[i-1][j-1];
				}
				else{
					ed[i][j] = Integer.min(ed[i-1][j-1], Integer.min(ed[i][j-1], ed[i-1][j])) + 1;
				}
			}
		}
		ans = ed[a.length()][b.length()];
		return ans;
	}

}
