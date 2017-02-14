package com.core.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			int[] a = new int[n];
			int i = 0;
			while(i<n){
				a[i++] = Integer.parseInt(br.readLine().trim()); 
			}
			
			int ans = computeLIS(a);
			System.out.println(ans);
		}
		
	}

	private static int computeLIS(int[] a) {
		// TODO Auto-generated method stub
		int ans = 0;
		int[] lis = new int[a.length];
		Arrays.fill(lis, 1);
		for(int i = 1 ; i < a.length ;i++){
			for(int j = 0 ; j<i;j++){
				if(a[i]>a[j] && lis[j]+1 > lis[i]){
					lis[i] = lis[j]+1;
					ans = Integer.max(ans, lis[i]);
				}
			}
		}
		printLIS(a, lis , ans);
		return ans;
	}

	private static void printLIS(int[] a, int[] lis, int ans) {
		// TODO Auto-generated method stub
//		ArrayList<Integer> an = new ArrayList<Integer>();
		int[] k = new int[ans+1];
		int last_inserted = 0;
		for(int i = a.length - 1 ; i >=0 && ans > 0; i--){
			if(lis[i] == ans && a[i]>last_inserted){
				k[ans--] = a[i];
				System.out.println(a[i]);
			}
		}
	}

}
