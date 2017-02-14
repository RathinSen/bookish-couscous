package com.core.revision;

import java.util.Scanner;

public class KMPAgain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String t = sc.next();
		String p = sc.next();
		kmpPrform(t,p);
		sc.close();
	}

	private static void kmpPrform(String t, String p) {
		// TODO Auto-generated method stub
		int[] l = new int[p.length()];
		fillprefixarray(l,p);
		int i = 0;
		int j = 0;
		while(i<t.length()){
			if(t.charAt(i)==p.charAt(j)){
				i++;
				j++;
				
			}
			if(j==p.length()){
				System.out.println(i-j);
				j = l[j-1];
			}
			else if(i < t.length() && t.charAt(i)!=p.charAt(j)){
				if(j!=0){
					j = l[j-1];
				}else if(j==0){
					i++;
				}
			}
		}
	}

	private static void fillprefixarray(int[] l, String p) {
		// TODO Auto-generated method stub
		int j = 0 ; 
		int i = 1;
		while(i < p.length()){
			if(p.charAt(i) == p.charAt(j)){
				j++;
				l[i++] = j;
			}else{
				if(j!=0){
					j = l[j-1];
				}
				else{
					i++;
				}
			}
		}
	}

}
