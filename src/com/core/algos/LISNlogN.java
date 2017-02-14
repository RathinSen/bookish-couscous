package com.core.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LISNlogN {

	//Incomplete
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			//ArrayList<Integer> can = new ArrayList<Integer>();
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ; i < n ; i++){
				a[i] = sc.nextInt();
			}
			computeLIS(a);
		}
		
	}

	private static void computeLIS(int[] a) {
		// TODO Auto-generated method stub
		int[] lis = new int[a.length+1];
		int len = 1;
		int i = 0;
		while(i < a.length){
			if(i==0){
				lis[i] = a[i];
			}
			else{
				if(a[i] > lis[len-1]){
					lis[len++] = a[i];
				}
				else
				{
					//replace(lis,a[i],len);
					replaceBS(lis,0,len-1,a[i]);
				}
			}
			i++;
		}
		System.out.println(len);
	}

	private static void replaceBS(int[] lis, int l, int r, int key) {
		// TODO Auto-generated method stub
		int index = ceilBIS(lis, l, r, key);
		lis[index] = key;
	}

	private static int ceilBIS(int[] lis, int l, int r, int key) {
		// TODO Auto-generated method stub
		if(l==r && key<=lis[r]){
			return r;
		}else if(r > l){
			int mid = l + (r-l)/2;
			if(lis[mid]>=key){
				return ceilBIS(lis, l, mid, key);
			}
			else{
				return ceilBIS(lis, mid+1, r, key);
			}
		}
		else{
			return -1;
			//if l > r
		}
	}

	private static void replace(int[] lis, int no, int len) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < len ; i++){
			if(i==0){
				if(lis[i]>no){
					lis[i] = no;
					break;
				}
			}
			else
			{
				if(lis[i]>no){
					lis[i] = no;
					break;
				}
			}
		}
		
	}

}
