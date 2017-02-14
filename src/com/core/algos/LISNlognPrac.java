package com.core.algos;

import java.util.Scanner;

public class LISNlognPrac {

		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while(t-->0){
				int n = sc.nextInt();
				int[] a = new int[n];
				for(int i = 0 ; i < n ; i ++){
					a[i] = sc.nextInt();
				}
				System.out.println(lis(a));
			}
			sc.close();
		}

		private static int lis(int[] a) {
			// TODO Auto-generated method stub
			int len = 1;
			int[] l = new int[a.length];
			int i = 0;
			while(i < a.length){
				if(i==0){
					l[i] = a[i];
				}
				else{
					if(a[i] > l[len - 1]){
						l[len++] = a[i];
					}
					else{
						//replace
						replace(l,0,len-1,a[i]);
					}
				}
				i++;
			}
			return len;
		}

		private static void replace(int[] lis, int l, int r, int k) {
			// TODO Auto-generated method stub
			int index = ceilBS(lis,0,r,k);
			lis[index] = k;
		}

		private static int ceilBS(int[] lis, int l, int r, int k) {
			// TODO Auto-generated method stub
			if(l==r && lis[r]>=k){
				return r;
			}
			else if(r>l){
				int mid = l + (r-l)/2;
				if(lis[mid]>=k){
					return ceilBS(lis, l, mid, k);
				}
				else{
					return ceilBS(lis, mid+1, r, k);
				}
			}
			else{
				return -1;
			}
		}
}
