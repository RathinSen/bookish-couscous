package com.core.algos;

import java.util.ArrayList;
import java.util.Scanner;

public class BuildHouses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		findWays(n);
	}

	private static void findWays(int n) {
		// TODO Auto-generated method stub
		ArrayList<String> in = new ArrayList<String>();
		ArrayList<String> help = new ArrayList<String>();
		in.add("S");
		in.add("B");
		for(int i = 2 ; i <= n ; i++ ){
			for(String s : in){
				if(s.charAt(s.length()-1)=='B'){
					help.add(s+'S');
				}
				else{
					help.add(s+"S");
					help.add(s+"B");
				}
			}
			in.clear();
			in.addAll(help);
			help.clear();
		}
		for(String i : in){
			System.out.println(i);
		}
		System.out.println(Math.pow(in.size(), 2));
		
	}

}
