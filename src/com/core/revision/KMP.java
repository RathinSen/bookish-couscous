package com.core.revision;

import java.util.Scanner;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String txt = sc.next();
		String pat = sc.next();
		kmp(txt,pat);
	}

	private static void kmp(String txt, String pat) {
		int[] prefix = preprocess(pat);
		//printprefix(prefix);
		int i = 0;
		int j = 0;
		while(i<txt.length()){
			if(txt.charAt(i)==pat.charAt(j)){
				i++;
				j++;
			}
			if(j==pat.length()){
				System.out.println(i-j);
				j = prefix[j-1];
			}
			else if(i < txt.length() && txt.charAt(i)!=pat.charAt(j)){
				if(j!=0){
					j = prefix[j-1];
				}else{
					i++;
				}
			}
			
		}
	}

	private static void printprefix(int[] prefix) {
		// TODO Auto-generated method stub
		for(int i : prefix){
			System.out.print(i+" ");
		}
	}

	private static int[] preprocess(String pat) {
		// TODO Auto-generated method stub
		int[] l = new int[pat.length()];
		l[0] = 0;
		int j = 0; 
		//WHILE LOOP IN PREPROCESS as I can be matched again with j
		int i =1;
		
		while(i<pat.length()){
			if(pat.charAt(i)==pat.charAt(j)){
				j++;
				l[i++] = j; 
			}
			else{
				if(j!=0){
					j=l[j-1];
				}else{
					i++;
				}
			}
		}
		
		return l;
	}

}
