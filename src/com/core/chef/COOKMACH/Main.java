package com.core.chef.COOKMACH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			String[] tkns = br.readLine().trim().split(" ");
			int a = Integer.parseInt(tkns[0]);
			int b = Integer.parseInt(tkns[1]);
			cookSettings(a,b);
			//System.out.println(Integer.toBinaryString(a)+" "+Integer.toBinaryString(b));
		}
		
	}

	private static void cookSettings(int a, int b) {
		// TODO Auto-generated method stub
		int mult = 0;
		boolean powerOf2 = checkIfPowerOf2(a);
		if(powerOf2){
			mult += getToB(a, b);
		}
		else{
			mult += makeItInPowerOf2(a,b);
		}
		System.out.println(mult);
	}

	private static int makeItInPowerOf2(int a, int b) {
		// TODO Auto-generated method stub
		int mult = 0;
		while(!checkIfPowerOf2(a)){
			if(a%2==0){
				a /=2;
			}else{
				a = (a-1)/2;
			}
			mult++;
		}
		mult += getToB(a, b);
		return mult;
	}

	private static int getToB(int a, int b) {
		int mult = 0;
		while(a!=b){
			if(a>b){
				a /=2;
			}else if(a<b){
				a*=2;
			}
			mult++;
		}
		return mult;
	}

	private static boolean checkIfPowerOf2(int a) {
		return (a & (a - 1)) == 0;
	}
}
