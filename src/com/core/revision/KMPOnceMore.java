package com.core.revision;

import java.util.Scanner;

public class KMPOnceMore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String t = sc.next();
		String p = sc.next();
		findMatch(t,p);
		sc.close();
	}

	private static void findMatch(String t, String p) {
		// TODO Auto-generated method stub
		int[] l = makePrefixArray(p);
		int i = 0;
		int j = 0;
		while(i < t.length()){
			if(t.charAt(i) == p.charAt(j)){
				i++;
				j++;
			}
			if(j==p.length()){
				System.out.println(i-j);
				j = l[j-1];
			}
			else if(i < t.length() && t.charAt(i) != p.charAt(j)){
				if(j!=0){
					j = l[j-1];
				}
				else{
					i++;
				}
			}
		}
	}

	private static int[] makePrefixArray(String p) {
		// TODO Auto-generated method stub
		int[] l = new int[p.length()];
		int i = 1;
		int j = 0;
		while(i<p.length()){
			if(p.charAt(j)==p.charAt(i)){
				j++;
				l[i++] = j;
				continue;
			}else{
				if(j!=0){
					j=l[j-1];
				}
				else if(j==0){
					i++;
				}
			}
		}
		return l;
	}

}
