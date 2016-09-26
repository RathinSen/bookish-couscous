package com.core.chef.TSORT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(t-->0){
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		for(Integer i: list){
			System.out.println(i);
		}
		
			
	}
}
