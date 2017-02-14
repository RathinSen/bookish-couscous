package com.core.chef2.CIELAB;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ans = findIncorrectAns(a,b);
		System.out.println(ans);
		sc.close();
	}

	private static int findIncorrectAns(int a, int b) {
		int ans = a - b;
		StringBuffer ansSb = new StringBuffer(String.valueOf(ans));
		//IF 9
		//System.out.println(ansSb.reverse());
		if(9 == Integer.parseInt(String.valueOf(ansSb.reverse().charAt(0)))){
			ans--;
		}
		else{
			ans++;
		}
		return ans;
	}
}
