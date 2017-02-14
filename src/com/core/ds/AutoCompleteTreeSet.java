package com.core.ds;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AutoCompleteTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] strings  = sc.next().trim().split(",");
		String txt = sc.next();
		SetTrie setTrie = new SetTrie();
		for(String s : strings){
			setTrie.insert(s);
		}
		//System.out.println(setTrie.dictionary);
		//System.out.println(setTrie.dictionary.tailSet(txt));
		for(String s : setTrie.dictionary.tailSet(txt)){
			if(s.startsWith(txt)){
				System.out.println(s);
			}
		}
		sc.close();
		
	}

}
class SetTrie{
	TreeSet<String> dictionary;
	
	
	public SetTrie() {
		this.dictionary = new TreeSet<String>();
	}


	public void insert(String phrase){
		this.dictionary.add(phrase);
	}
}
