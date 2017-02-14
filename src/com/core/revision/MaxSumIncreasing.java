package com.core.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumIncreasing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String[] tkns = br.readLine().trim().split(",");
		int[] a = new int[tkns.length];
		for(int i = 0 ; i <tkns.length;i++){
			a[i] = Integer.parseInt(tkns[i].trim());
 		}
		findMax(a);
	}

	private static void findMax(int[] a) {
		// TODO Auto-generated method stub
		int[] l = new int[a.length];
		for(int i = 0 ; i<a.length;i++ ){
			l[i] = a[i];
		}
		int max = l[0];
		for(int i = 1; i<a.length;i++){
			for(int j = 0 ; j < i ; j++){
				if(a[i]>a[j] && l[i]<l[j]+a[i]){
					l[i] = l[j]+a[i];
					max = Integer.max(l[i], max);
				}
			}
		}
		System.out.println(max);
		
	}

}
