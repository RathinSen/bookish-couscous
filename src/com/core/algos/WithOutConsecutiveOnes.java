package com.core.algos;

import java.util.ArrayList;
import java.util.Scanner;

public class WithOutConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		findTotal(n);
		sc.close();
		
	}

	private static void findTotal(int n) {
		// TODO Auto-generated method stub
		ArrayList<String> in  = new ArrayList<String>();
		ArrayList<String> h  = new ArrayList<String>();
		in.add("0");
		in.add("1");
		for(int i = 2 ; i<=n ;i++){
			for(String s : in){
				if(s.charAt(s.length()-1)!='1'){
					h.add(s+'1');
					h.add(s+'0');
				}
				else{
					h.add(s+'0');
				}
				
			}
			in.clear();
			in.addAll(h);
			h.clear();
		}
		System.out.println(in.size());
	}

}
