package com.core.chef.FLOW016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			String[] tokens = br.readLine().trim().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			System.out.println(gcd(a,b)+" "+lcm(a,b));
		}
	}

	private static long lcm(int a, int b) {
		// TODO Auto-generated method stub
		int c = gcd(a,b);
		if(c>1){
			a/=c;
			b/=c;
		}
		return (long) c*a*b;
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		if(b==0){
			return a;
		}else{
			return gcd(b,a%b);
		}
	}

}
