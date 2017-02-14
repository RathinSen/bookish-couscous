package com.core.hr;

import java.util.Scanner;

public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String cS = compressedString2(s);
		System.out.println(cS);
		sc.close();
	}

	private static String compressedString2(String s) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer();
		int count = 1;
		for(int i = 1 ; i <= s.length();i++){
			if(i!=s.length()){
				if(s.charAt(i-1) == s.charAt(i)){
					count++;
					continue;
				}
				else{
					helper(count,str,s,i);
					count = 1;
				}
			}
			else{
				helper(count,str,s,i);
			}
		}
		return str.toString();
	}
	
	private static void helper(int count, StringBuffer str, String s, int i){
		if(count == 1){
			str.append(s.charAt(i-1));
//		}else if(count == 2){
//			str.append(s.charAt(i-1)).append(s.charAt(i-1));
		}else if(count > 1){
			str.append(s.charAt(i-1)+""+count);
		}
	}

	private static String compressedString(String s) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer();
		//int count = 1;
		int[] a = new int[26];
		for(int i = 0 ; i < s.length();i++){
			a[s.charAt(i)-'a']++;
		}
		for(int i = 0 ; i < a.length;i++){
			if(a[i]>0){
				char b = (char) ((int)'a'+i);
				if(a[i]>2){
					str.append(b+""+a[i]);
				}
				else{
					switch(a[i]){
					case 1:
						str.append(b);
						break;
					case 2:
						str.append(b).append(b);
						break;
					}
				}
			}
		}
		return str.toString();
	}

}
