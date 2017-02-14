package com.core.revision;

import java.util.Scanner;

public class MinJumpsToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().trim().split(",");
		int[] a = new int[s.length];
		for(int i = 0 ; i < s.length ; i++){
			a[i] = Integer.parseInt(s[i].trim());
		}
		findMaxJumps(a);
		sc.close();
	}

	private static void findMaxJumps(int[] a) {
		// TODO Auto-generated method stub
		int[] l = new int[a.length];
		for(int i = a.length-1;i>=0;i--){
			if(a[i]>=a.length-1-i){
				l[i] = 1;
			}
			else{
				l[i] = Integer.MAX_VALUE;
				for(int j = 1;j<=a[i];j++){
					if(l[i+j]==Integer.MAX_VALUE){
						continue;
					}else{
						l[i] = Integer.min(l[i],1+ l[i+j]);
					}
					//l[i] = Integer.min(l[i],1+ l[i+j]);
				}
			}
		}
		System.out.println(l[0]);
	}

}
