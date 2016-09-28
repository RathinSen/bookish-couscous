package com.core.chef.CHEFSTLT;

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
			System.out.println(minMaxDiff(s1,s2));
		}
	}

	private static String minMaxDiff(String s1, String s2) {
		String ans;
		int min = 0;
		int max = 0;
		min += Integer.max(s1.length(), s2.length()) - Integer.min(s1.length(), s2.length());
		max += Integer.max(s1.length(), s2.length()) - Integer.min(s1.length(), s2.length());
		for(int i = 0 ; i < Integer.min(s1.length(), s2.length()); i++){
			if(s1.charAt(i)!='?' && s1.charAt(i) == s2.charAt(i)){
				continue;
			}
			else if(s1.charAt(i)=='?' || s2.charAt(i)=='?'){
				max++;
			}else if(s1.charAt(i)!=s2.charAt(i)){
				min++;
				max++;
			}
		}
		ans = new String(min+" "+max);
		return ans;
	}
}
