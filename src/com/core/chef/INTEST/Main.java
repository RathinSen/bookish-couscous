package com.core.chef.INTEST;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = Integer.parseInt(sc.next());
		int counter=0;
		while(n-->0){
			int t  = sc.nextInt();
			if(t%m==0)
			{
				counter++;
			}
		}
		System.out.println(counter);
	}
}
