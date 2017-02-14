package com.core.algos;

import java.util.Scanner;

public class LexoGraphicRankON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
		findRank(s);
		sc.close();
	}

	private static void findRank(String s) {
		// TODO Auto-generated method stub
		int[] count = new int[257];
		int rank =1;
		prepaerCount(count, s);
		int coeff = fact(s.length());
		for(int i = 0 ; i < s.length() ; i++){
			coeff /= s.length() - i;
			//rank+= coeff*(count[s.charAt(i)]-1);
			//count[ str[i] - 1]
			rank+= coeff*count[ s.charAt(i) - 1];
			update(count,s.charAt(i));
		}
		System.out.println(rank);
	}

	private static void update(int[] count, char charAt) {
		// TODO Auto-generated method stub
		for(int i=charAt ; i < count.length ;i++ ){
			count[i]--;
		}
	}

	private static void prepaerCount(int[] count, String s) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < s.length() ; i++){
			count[s.charAt(i)]++;
			}
		for(int i = 1 ; i < count.length ; i++){
			count[i] +=count[i-1];
		}
		
	}

	private static int fact(int length) {
		// TODO Auto-generated method stub
		int[] f = new int[length+1];
		f[0] = f[1] = 1;
		for(int i =2 ; i <=length ; i++){
			f[i] = i*f[i-1];
		}
		return f[length];
	}

}
