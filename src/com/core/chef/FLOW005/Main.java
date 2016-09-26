package com.core.chef.FLOW005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] denominations = new int[]{100,50,10,5,2,1};
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			System.out.println(MinNotes(n,denominations));
		}
	}

	private static int MinNotes(int n, int[] denominations) {
		int counter = 0;
		for(int i = 0 ;i < denominations.length && n>0 ;i++){
			if(n<denominations[i]){
				continue;
			}
			else{
				counter+=(n/denominations[i]);
				n = n%denominations[i];
				
			}
		}
		return counter;
	}

}
