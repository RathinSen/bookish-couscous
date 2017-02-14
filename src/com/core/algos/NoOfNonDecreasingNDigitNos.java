package com.core.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NoOfNonDecreasingNDigitNos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
		findNos(n,list);
		sc.close();
		
	}

	private static void findNos(int n, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		int i = 1;
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		while(i<n){
			for(Integer l : list){
				int last = getLastInt(l);
				for(int j=0;j<=9;j++){
					if(last<j){
						String s = l+""+j;
						list2.add(Integer.parseInt(s));
					}
				}
			}
			list.clear();
			list.addAll(list2);
			list2.clear();
			i++;
		}
		
		System.out.println(list.size());
		System.out.println(list);
	}

	private static int getLastInt(Integer l) {
		// TODO Auto-generated method stub
		String s = l.toString();
		
		return Integer.parseInt(s.substring(s.length()-1));
	}

}
