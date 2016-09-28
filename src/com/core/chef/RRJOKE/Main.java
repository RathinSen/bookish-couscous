package com.core.chef.RRJOKE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			for(int i = 0 ; i < n ; i++){
				String s = br.readLine().trim();
			}
			System.out.println(xorUpto(n));
		}
	}

	private static int xorUpto(int n) {
		// TODO Auto-generated method stub
		int ans = 0;
		for(int i = 1 ; i <= n ; i++){
			ans ^=i;
		}
		return ans;
	}

}
