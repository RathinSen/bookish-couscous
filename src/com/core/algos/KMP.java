package com.core.algos;

import java.util.Scanner;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		String a =  sc.next();
		String pat =  sc.next();
		int[] lps = makeLPS(pat);
		//printLPS(lps);
		match(lps, a, pat);
		sc.close();
		
	}

	private static void match(int[] lps, String a, String pat) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		while(i < a.length()){
			if(a.charAt(i) == pat.charAt(j)){
				i++;
				j++;
			}
			if(j==pat.length()){
				System.out.println(i-pat.length());
				j=lps[j-1];
			}
			else if(i<a.length() && a.charAt(i) != pat.charAt(j)){
				if(j>0){
					j=lps[j-1];
				}
				else{
					i++;
				}
			}
		}
	}

	private static void printLPS(int[] lps) {
		// TODO Auto-generated method stub
		for(int i : lps){
			System.out.println(i);
		}
		
	}

	private static int[] makeLPS(String pat) {
		int[] p = new int[pat.length()];
		int i = 1;
		int len = 0;
		while(i  < pat.length()){
			if(pat.charAt(i) == pat.charAt(len)){
				len++;
				p[i++] = len;
			}
			else{
				if(len>0){
					len = p[len-1];
				}
				else{
					p[i++] = 0;
				}
			}
		}
		return p;
	}

}
