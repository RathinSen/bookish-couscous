package com.core.algos;

import java.util.Scanner;

public class LBS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i++){
			a[i] = sc.nextInt();
		}
		peformLBS(a);
		sc.close();
	}

	private static void peformLBS(int[] a) {
		// TODO Auto-generated method stub
		int[] lis = new int[a.length];
		int[] lds = new int[a.length];
		
		for(int i = 0 ; i < a.length;i++ ){
			lis[i] = 1;
			lds[i] = 1;
		}
		for(int i = 1; i < a.length ;i++){
			for(int j = 0 ; j<a.length;j++){
				if(a[i] > a[j] && lis[j]+1>lis[i])
					lis[i] = 1+lis[j];
			}
			//System.out.print(lis[i]+" ");
		}
		System.out.println();
		for(int i = a.length-2;i>=0;i--){
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[i] && lds[j]+1>lds[i]){
					lds[i]=1+lds[j];
				}
			}
			//System.out.print(lds[i]+" ");
		}
		int max = 0;
		for(int i = 0 ; i<a.length;i++){
			System.out.println(lis[i]+" "+lds[i]);
			max = Integer.max(max, lis[i]+lds[i]-1);
		}
		System.out.println(max);
	}

}
