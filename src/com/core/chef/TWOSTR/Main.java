package com.core.chef.TWOSTR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			String s1 = br.readLine().trim();
			String s2 = br.readLine().trim();
			boolean yes = canMatch(s1,s2);
			if(yes){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

	private static boolean canMatch(String s1, String s2) {
		// TODO Auto-generated method stub
		boolean yes = false;
		if(s1.length() == s2.length()){
			for(int i = 0 ; i <s1.length() ; i++){
				if(s1.charAt(i)==s2.charAt(i) || s1.charAt(i)=='?' || s2.charAt(i) =='?'){
					if(i==s1.length()-1){
						yes = true;
					}
				}else{
					break;
				}
			}
		}
		return yes;
	}

}
