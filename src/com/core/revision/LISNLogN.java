package com.core.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LISNLogN {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().trim().split(",");
		int[] a = new int[s.length];
		for(int i = 0 ; i < s.length ; i ++){
			a[i] = Integer.parseInt(s[i].trim());
		}
		findLis(a);
	}

	private static void findLis(int[] a) {
		// TODO Auto-generated method stub
		int[] l = new int[a.length];
		int len = 1;
		l[0] = a[0];
		for(int i = 1; i < a.length;i++){
			if(a[i]>l[len-1]){
				l[len++] = a[i];
			}
			else if(a[i]<l[0]){
				l[0] = a[i];
			}
			else{
				//replace
				replace(l,0,len-1,a[i]);
			}
		}
		System.out.println(len);
	}

	private static void replace(int[] l, int le, int ri, int k) {
		// TODO Auto-generated method stub
		int index = ceilbs(l,le,ri,k);
		l[index] = k;
		
	}

	private static int ceilbs(int[] l, int le, int ri, int k) {
		// TODO Auto-generated method stub
		if(ri>le){
			int mid = le + (ri-le)/2;
			if(l[mid]>=k){
				return ceilbs(l,le,mid,k);
			}
			else
				return ceilbs(l,mid+1,ri,k);
		}
		else if(ri==le && l[ri]>=k){
			return ri;
		}
		else{
			return -1;
		}
	}

}
