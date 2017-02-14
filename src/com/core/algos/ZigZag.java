package com.core.algos;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next().trim();
		int n = sc.nextInt();
		printZigZag(s,n);
		sc.close();
		
	}

	private static void printZigZag(String s, int n) {
		// TODO Auto-generated method stub
		StringBuffer[] zz = new StringBuffer[n];
		Arrays.fill(zz, new StringBuffer());
		boolean r = false;
		for(int i = 0 ; i < s.length() ; i++){
			if(i%n==0){
				r=!r;
			}
			if(r)
				zz[i%n].append(s.charAt(i));
			else
				zz[(i+1)%n].append(s.charAt(i));
			
		}
		StringBuffer sb = new StringBuffer();
		for(StringBuffer z : zz){
			sb.append(z);
		}
		System.out.println(sb.toString());
	}

}
