package com.core.revision;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AutoCompleteTreeSetAgain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] strings  = sc.next().split(",");
		String pat = sc.next();
		TreeSet<String> dictionary = new TreeSet<String>();
		for(String s : strings){
			dictionary.add(s);
		}
		Set<String> remainder = dictionary.tailSet(pat);
		for(String s : remainder){
			if(s.startsWith(pat)){
				System.out.println(s);
			}
		}
		
		sc.close();
	}

}
