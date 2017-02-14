package com.core.revision;

import java.util.Scanner;

public class LongestBitonic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().trim().split(",");
		int[] a  = new int[s.length];
		for(int i = 0 ; i < s.length;i++){
			a[i] = Integer.parseInt(s[i]);
		}
		findLongestBitonice(a);
		sc.close();
	}

	private static void findLongestBitonice(int[] a) {
		// TODO Auto-generated method stub
		int[] lis = new int[a.length];
		int[] lds = new int[a.length];
		
		for(int i=0 ; i < a.length ; i++){
			lis[i] = 1;
			lds[i] = 1;
		}
		for(int i = 1; i <a.length;i++){
			for(int j = 0 ; j<i;j++){
				if(a[i]>a[j] && lis[i]<1+lis[j]){
					lis[i] = lis[j]+1;
				}
			}
		}
		for(int i = a.length-2;i>=0;i--){
			for(int j = a.length-1;j>i;j--){
				if(a[i]>a[j] && lds[i]<1+lds[j]){
					lds[i] = 1+lds[j];
				}
			}
		}
		int max = 1;
		for(int i = 0 ; i < a.length ;i++){
			max = Integer.max(max, lis[i]+lds[i]-1);
		}
		System.out.println(max);
	}

}
