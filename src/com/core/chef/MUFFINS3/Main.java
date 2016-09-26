package com.core.chef.MUFFINS3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(t-->0){
			list.add(Integer.parseInt(br.readLine()));
		}
		for(Integer i:list){
			calMaxDiff(i);
		}
	}

	private static void calMaxDiff(Integer i) {
		int max_j = 2;
		if(i>2)
		{
			max_j = i/2+1;
		}
		
		System.out.println(max_j);
	}

}
