package com.core.algos;

import java.util.Scanner;

public class JumpFromStartToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i++){
			a[i] = sc.nextInt();
		}
		sc.close();
		minJumps(a);
	}

	private static void minJumps(int[] a) {
		// TODO Auto-generated method stub
		int[] l = new int[a.length];
		l[a.length-1] = 0;
		for(int i = a.length-2;i>=0;i--){
			if(a.length-1 - i > a[i]){
				l[i]=Integer.MAX_VALUE;
				if(a[i]==0){
					continue;
				}
				else{
					for(int  j = 1 ; j <= a[i] ; j++){
						l[i] = Integer.min(l[i], l[i+j]+1);
					}
				}
			}
			else{
				l[i] = 1;
			}
		}
		for(int i = 0 ; i < a.length; i++)
			System.out.print(l[i]+" ");
		//System.out.println(l[0]);
	}

}
