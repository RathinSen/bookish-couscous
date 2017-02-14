package com.core.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PermuteOfAString {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s= sc.next();
		ArrayList<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer(s);
		perm(sb,0,s.length()-1,list);
		Collections.sort(list);
		int i = 0;
		for(String ss : list){
			i++;
			System.out.println(i+" "+ss);
		}
		sc.close();
	}

	private static void perm(StringBuffer sb, int l, long r, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if(l==r)
			list.add(sb.toString());
		for(int  i = l ; i <= r; i++){
			if(sb.charAt(l)!=sb.charAt(i) || l==i){
				swap(sb,l,i);
				perm(sb,l+1,r,list);
				swap(sb,i,l);
			}
		}
		
	}

	private static void swap(StringBuffer sb, int l, int i) {
		// TODO Auto-generated method stub
		char a = sb.charAt(i);
		char b = sb.charAt(l);
		sb.setCharAt(l, a);
		sb.setCharAt(i, b);
	}

	
}
