package com.core.revision;

import java.util.Scanner;

public class KMPagainn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String t = sc.next().trim();
		String p = sc.next().trim();
		kmp(t,p);
		sc.close();
	}

	private static void kmp(String t, String p) {
		// TODO Auto-generated method stub
		int[] l = pre(p);
		int i = 0;
		int j = 0;
		while(i < t.length()){
			if(t.charAt(i) == p.charAt(j)){
				i++;
				j++;
			}
			if(j==p.length()){
				System.out.println(i-j);
				j=l[j-1];
			}
			else if(i < t.length() && t.charAt(i)!=p.charAt(j)){
				if(j!=0){
					j = l[j-1];
				}
				else{
					i++;
				}
			}
		}
	}

	private static int[] pre(String p) {
		// TODO Auto-generated method stub
		int[] l = new int[p.length()];
		int i = 1;
		int j = 0;
		while(i<p.length()){
			if(p.charAt(i) == p.charAt(j)){
				j++;
				l[i++] = j;
			}else{
				if(j!=0){
					j = l[j-1];
				}
				else if(j==0){
					i++;
				}
			}
		}
		return l;
	}

}
