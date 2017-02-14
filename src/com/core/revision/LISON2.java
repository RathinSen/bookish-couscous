package com.core.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LISON2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split(" ");
		int[] a = new int[s.length];
		for(int i = 0 ; i < a.length;i++){
			a[i] = Integer.parseInt(s[i].trim());
		}
		findLis(a);
	}

	private static void findLis(int[] a) {
		// TODO Auto-generated method stub
		int[] l = new int[a.length];
		Arrays.fill(l, 1);
		int max = 1;
		for(int  i = 1 ; i < a.length ; i++){
			for(int j = 0 ; j < i ; j++){
				if(a[i]>=a[j] && l[i]<=l[j]+1){
					l[i] = l[j]+1;
					max = Integer.max(l[i], max);
				}
			}
		}
		System.out.println(max);
	}

}
