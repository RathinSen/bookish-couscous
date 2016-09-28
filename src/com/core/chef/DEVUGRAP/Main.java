package com.core.chef.DEVUGRAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			String[] n_k = br.readLine().trim().split(" ");
			int n = Integer.parseInt(n_k[0]);
			int k = Integer.parseInt(n_k[1]);
			int[] grapesInBucket = new int[n];
			String[] tokens = br.readLine().trim().split(" ");
			for(int i = 0 ; i<n; i++){
				grapesInBucket[i] = Integer.parseInt(tokens[i]);
			}
			System.out.println(countOperations(grapesInBucket, k));
		}
	}

	private static int countOperations(int[] grapesInBucket, int k) {
		// TODO Auto-generated method stub
		int ans = 0 ;
		for(int i : grapesInBucket){
			if(i%k==0)
				continue;
			else{
				ans+= Integer.min(i%k, k - (i%k));
			}
		}
		return ans;
		
	}

}
