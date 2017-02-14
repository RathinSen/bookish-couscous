package com.core.revision;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AutocompleteTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] dictionary = sc.next().trim().split(",");
		String txt = sc.next().trim();
		TreeSet<String> set = new TreeSet<String>();
		
		for(String eachWord : dictionary){
			set.add(eachWord.trim());
		}
		
		Set<String> pWs= set.tailSet(txt);
		for(String pW : pWs){
			if(pW.startsWith(txt)){
				System.out.println(pW);
			}
		}

	}

}
