package com.core.algos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CorrectInvalidParenthesesBFS {

	public static final char OPEN_PARENTHESIS ='(';
	public static final char CLOSE_PARENTHESIS =')';
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		String exp = sc.next();
		getBackValid(exp);
		sc.close();
	}

	private static void getBackValid(String exp) {
		// TODO Auto-generated method stub
		Queue<String>  q = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		Set<String> ans = new HashSet<String>();
		q.add(exp);
		visited.add(exp);
		while(!q.isEmpty()){
			String a = q.poll();
			if(ValidString(a)){
				ans.add(a);
				continue;
			}
			else{
				for(int i = 0 ; i < a.length() ;i++){
					if(!isParentheses(a.charAt(i)))
						continue;
					else{
						String t = a.substring(0,i) + a.substring(i+1);
						if(!visited.contains(t)){
							q.add(t);
							visited.add(t);
						}
					}
				}
			}
		}
		System.out.println(ans.toString());
	}

	private static boolean isParentheses(char c) {
		// TODO Auto-generated method stub
		return (c==OPEN_PARENTHESIS || c==CLOSE_PARENTHESIS);
	}

	private static boolean ValidString(String a) {
		// TODO Auto-generated method stub
		int open_p=0;
		for(int i = 0 ; i  < a.length(); i ++){
			if(a.charAt(i)==OPEN_PARENTHESIS){
				open_p++;
			}
			else if(a.charAt(i)==CLOSE_PARENTHESIS){
				if(open_p>0){
					open_p--;
				}else{
					return false;
				}
			}
		}
		return (open_p==0);
	}

}
