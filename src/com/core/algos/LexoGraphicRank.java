package com.core.algos;

import java.util.Scanner;

public class LexoGraphicRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(rank(s,0,s.length()-1));
		sc.close();
	}

	private static int rank(String s, int l, int r) {
		// TODO Auto-generated method stub
		if(l==r)
			return 1;
		int rank = 0;
		char c = s.charAt(l);
		int smaller_chars=0;
		for(int i = l ; i <=r ;i++){
			if(s.charAt(i)<c){
				smaller_chars++;
			}
		}
		rank+=smaller_chars*fact(r-l);
		rank+=rank(s,l+1,r);
		return rank;
	}

	private static int fact(int n) {
		// TODO Auto-generated method stub
		int[] l = new int[n+1];
		l[0] = 1;
		for(int i = 1 ; i <= n ; i++){
			l[i] = i*l[i-1];
		}
		return l[n];
	}

}
