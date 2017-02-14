package com.rathinSen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		printLen(s);
	}

	private static void printLen(String s) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> visisted  = new HashSet<String>();
		ArrayList<String> strings = new ArrayList<String>();
 		queue.add(s);
 		visisted.add(s);
 		
 		boolean found = false;
		while(!queue.isEmpty()){
			String h = queue.poll();
			if(isValid(h)){
				strings.add(h);
				found  = true;
				
			}
			if(found) continue;
			for(int i  = 0 ; i < h.length() ; i++){
				String g = h.substring(0, i) + h.substring(i+1);
				if(!visisted.contains(g)){
					queue.add(g);
					visisted.add(g);
				}
			}
		}
		int max = 0;
		for(String result : strings){
			if(result.length()>=max){
				max = result.length();
			}
		}
		System.out.println(max);
	}

	private static boolean isValid(String s) {
		// TODO Auto-generated method stub
		int count = 0 ;
		for(int i = 0 ; i < s.length() ;i++){
			char c = s.charAt(i);
			if(c == '('){
				count++;
			}
			else if(c == ')')
			{
				count --;
			}
		}
		return count == 0;
	}

}
