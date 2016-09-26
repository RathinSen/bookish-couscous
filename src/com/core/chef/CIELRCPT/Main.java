package com.core.chef.CIELRCPT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			System.out.println(getMinMenus(n));
		}
	}

	private static int getMinMenus(int n) {
		int counter = 0 ;
		if(n<=2048){
			String[] binaryStringArray = Integer.toBinaryString(n).split("");
			for(String s : binaryStringArray){
				if(Integer.parseInt(s)==1){
					counter++;
				}
			}
			return counter;
		}
		else{
			return 1 + getMinMenus(n-2048);
		}
		
		
	}
	

}
