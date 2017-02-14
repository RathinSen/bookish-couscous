package com.core.revision;

import java.util.Scanner;

public class LISNlogNz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().trim().split(",");
		int[] a = new int[s.length];
		for(int i = 0 ; i < s.length;i++){
			a[i] = Integer.parseInt(s[i].trim());
		}
		lis(a);
		sc.close();
	}

	private static void lis(int[] a) {
		int[] l = new int[a.length];
		l[0] = a[0];
		int len=1;
		for(int i  = 1; i <a.length;i++){
			if(a[i]>l[len-1]){
				l[len++] = a[i];
			}
			else if(a[i]<l[0]){
				l[0] = a[i];
			}
			else{
				int index = ceil(l,len-1,a[i]);
				l[index] = a[i];
			}
			
		}
		System.out.println(len);
	}

	private static int ceil(int[] l, int r, int key) {
		// TODO Auto-generated method stub
		int index = ceilBS(l,0,r,key);
		return index;
	}

	private static int ceilBS(int[] a, int l, int r, int key) {
		// TODO Auto-generated method stub
		if(l<r){
			int mid = l + (r-l)/2;
			if(a[mid]<key){
				return ceilBS(a,mid+1,r,key);
			}else{
				return ceilBS(a,l,mid,key);
			}
		}
		else if(l==r && a[l]>=key){
			return r;
		}
		else
			return -1;
	}

}
